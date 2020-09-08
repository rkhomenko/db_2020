package my_spring.context;

import my_spring.config.ConfigLoader;

public interface ApplicationContext {
    void setConfigLoader(ConfigLoader configLoader);
    <T> T getBean(Class<T> clazz);
}
