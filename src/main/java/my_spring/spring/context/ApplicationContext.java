package my_spring.spring.context;

public interface ApplicationContext {
    <T> T getBean(String idOrClassName);
    <T> T getBean(Class<T> clazz);
}
