package my_spring.context;

import my_spring.config.JavaConfigLoader;
import my_spring.factory.ObjectFactory;

public class JavaConfigContext implements ApplicationContext {
    private static ObjectFactory objectFactory = ObjectFactory.getInstance();

    static {
        objectFactory.setConfigLoader(new JavaConfigLoader());
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return objectFactory.createObject(clazz);
    }
}
