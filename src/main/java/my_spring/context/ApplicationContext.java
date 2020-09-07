package my_spring.context;

public interface ApplicationContext {
    <T> T getBean(Class<T> clazz);
}
