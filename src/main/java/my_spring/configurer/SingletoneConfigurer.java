package my_spring.configurer;

import my_spring.annotation.Singleton;
import my_spring.factory.ObjectFactory;

public class SingletoneConfigurer implements ObjectConfigurer{
    @Override
    public void configure(Object t) {
        if (t.getClass().isAnnotationPresent(Singleton.class)) {
            ObjectFactory.addSingletone((Class<Object>)t.getClass(), t);
        }
    }
}
