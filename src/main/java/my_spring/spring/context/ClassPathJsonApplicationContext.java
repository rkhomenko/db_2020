package my_spring.spring.context;

import my_spring.spring.factory.BeanFactory;
import my_spring.spring.factory.ClassPathJsonBeanFactory;

public class ClassPathJsonApplicationContext implements ApplicationContext {
    private static BeanFactory beanFactory = new ClassPathJsonBeanFactory();

    @Override
    public <T> T getBean(String idOrClassName) {
        return beanFactory.createBean(idOrClassName);
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return beanFactory.createBean(clazz);
    }
}
