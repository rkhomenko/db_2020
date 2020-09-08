package my_spring.config;

import my_spring.annotation.JavaConfig;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class JavaConfigLoader implements ConfigLoader {
    private final Map<Class<?>, Class<?>> interfaceClassMap = new HashMap<>();

    public JavaConfigLoader(String packageName) {
        Reflections scanner = new Reflections(packageName);
        var classSet = scanner.getTypesAnnotatedWith(JavaConfig.class);
        if (classSet.size() == 0) {
            throw new ConfigLoaderException("Cannot find class annotated with @JavaConfig");
        } else if (classSet.size() > 1) {
            throw new ConfigLoaderException("Find more than one class annotated with @JavaConfig");
        }

        var configClass = classSet.iterator().next();
        for (var method : configClass.getDeclaredMethods()) {
            if (method.getParameterCount() == 0) {
                throw new ConfigLoaderException("Method without arguments not supported");
            } else if (method.getParameterCount() != 1) {
                throw new ConfigLoaderException("Multiple argument methods not supported");
            }

            Class<?> implementationClass = method.getParameterTypes()[0];
            Class<?> implementedInterface = method.getReturnType();

            interfaceClassMap.put(implementedInterface, implementationClass);
        }
    }

    @Override
    public <T> Class<? extends T> getImpl(Class<T> clazz) {
        return (Class<? extends T>) interfaceClassMap.get(clazz);
    }
}
