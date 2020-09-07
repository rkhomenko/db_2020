package my_spring;

import heroes.RandomUtil;
import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {



    private static ObjectFactory objectFactory = new ObjectFactory();
    @Setter
    private Config config;

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();

    private Reflections scanner = new Reflections("my_spring");

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = resolveImpl(type);
        T t = create(implClass);
        t = injectDependencies(type, t);
        configure(t);
        return t;
    }

    private <T> T injectDependencies(Class<T> clazz, T t) throws IllegalAccessException {
        List<Field> autowiredFields = new ArrayList<>();
        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                autowiredFields.add(field);
            }
        }

        for (var field : autowiredFields) {
            Object obj = ObjectFactory.getInstance().createObject(field.getType());
            boolean accessible = field.canAccess(t);
            field.setAccessible(true);
            field.set(t, obj);
            field.setAccessible(accessible);
        }

        return t;
    }

    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t));
    }

    private <T> T create(Class<? extends T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }

    private <T> Class<? extends T> resolveImpl(Class<T> type) {
        Class<? extends T> implClass;
        if (type.isInterface()) {
            implClass = config.getImpl(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl, please update your config");
                }
                implClass = classes.iterator().next();
            }
        }else {
            implClass = type;
        }
        return implClass;
    }
}







