package my_spring.config;

public interface ConfigLoader {
    <T> Class<? extends T> getImpl(Class<T> clazz);
}
