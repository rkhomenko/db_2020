package my_spring.context;

import lombok.Getter;
import my_spring.annotation.Singleton;
import my_spring.config.ConfigLoader;
import my_spring.factory.ObjectFactory;

import java.util.HashMap;
import java.util.Map;

public class MyApplicationContext implements ApplicationContext {
    private ObjectFactory objectFactory;
    private Map<Class<?>, Object> singletoneCache = new HashMap<>();

    @Getter
    private Map<Class<?>, Integer> testCounterMap = new HashMap<>();

    public MyApplicationContext(ConfigLoader configLoader) {
        objectFactory = new ObjectFactory(configLoader);
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return getFromCacheOrCreate(clazz);
    }

    private <T> T getFromCacheOrCreate(Class<T> clazz) {
        if (singletoneCache.containsKey(clazz)) {
            return (T) singletoneCache.get(clazz);
        }

        if (testCounterMap.containsKey(clazz)) {
            testCounterMap.put(clazz, testCounterMap.get(clazz) + 1);
        } else {
            testCounterMap.put(clazz, 1);
        }

        T obj = (T) objectFactory.createObject(clazz);
        if (clazz.isAnnotationPresent(Singleton.class)) {
            singletoneCache.put(clazz, obj);
        }

        return obj;
    }
}
