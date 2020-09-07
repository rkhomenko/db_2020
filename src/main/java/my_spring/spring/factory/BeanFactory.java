package my_spring.spring.factory;

public interface BeanFactory {
    <T> T createBean(Class<T> clazz);
    <T> T createBean(String idOrClassName);
}
