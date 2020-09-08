package my_spring.config;

import org.reflections.Reflections;

public interface ConfigLoader {
    <T> Class<? extends T> getImpl(Class<T> clazz);
    Reflections getScanner();
}
