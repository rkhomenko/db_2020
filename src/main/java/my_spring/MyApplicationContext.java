package my_spring;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyApplicationContext implements ApplicationContext {
    private static ObjectFactory factory = ObjectFactory.getInstance();

    @Override
    public <T> T getBean(Class<T> clazz) {
        return factory.createObject(clazz);
    }
}
