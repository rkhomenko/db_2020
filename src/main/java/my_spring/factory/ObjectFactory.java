package my_spring.factory;

import lombok.Setter;
import lombok.SneakyThrows;
import my_spring.annotation.InjectByType;
import my_spring.config.ConfigLoader;
import my_spring.configurer.ObjectConfigurer;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Setter
    private ConfigLoader configLoader;

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();

    @Setter
    private Reflections scanner;

    @SneakyThrows
    public ObjectFactory(ConfigLoader configLoader) {
        setConfigLoader(configLoader);
        setScanner(configLoader.getScanner());

        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = resolveImpl(type);
        T t = create(implClass);
        injectByType(t);
        configure(t);
        invokeInitMethod(implClass, t);
        return t;
    }

    @SneakyThrows
    private <T> void injectByType(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object value = createObject(field.getType());
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }


    private <T> void invokeInitMethod(Class<? extends T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
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
            implClass = configLoader.getImpl(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl, please update your config");
                }
                implClass = classes.iterator().next();
            }
        } else {
            implClass = type;
        }
        return implClass;
    }
}








