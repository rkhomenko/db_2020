package my_spring;

public interface ApplicationContext {
    <T> T getBean(Class<T> clazz);
}
