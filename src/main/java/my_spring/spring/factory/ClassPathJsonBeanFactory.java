package my_spring.spring.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
class JsonBean {
    private String id;
    private String className;
}

@Getter
class JsonBeans {
    List<JsonBean> beans;
}

public class ClassPathJsonBeanFactory implements BeanFactory {
    private static JsonBeans jsonBeans;
    private static Map<String, Class<?>> idClassMap = new HashMap<>();
    private static Map<Class<?>, Object> classObjectMap = new HashMap<>();
    static {
        URL settings = Thread.currentThread()
                .getContextClassLoader()
                .getResource("beans.json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonBeans = objectMapper.readValue(settings, JsonBeans.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (JsonBean bean : jsonBeans.getBeans()) {
            try {
                Class<?> clazz = Class.forName(bean.getClassName());
                for (var ctor : clazz.getDeclaredConstructors()) {
                    if (ctor.getParameterCount() == 0) {
                        Object obj = ctor.newInstance();
                        Class<?>[] interfaces = clazz.getInterfaces();
                        if  (interfaces.length != 1) {
                            throw new RuntimeException("Multiple interfaces not supported");
                        }
                        classObjectMap.put(interfaces[0], obj);
                    } else {
                        List<Object> argumentList = new ArrayList<Object>();
                        for (var ctorType : ctor.getParameterTypes()) {
                            argumentList.add(classObjectMap.get(ctorType));
                        }

                        classObjectMap.put(clazz, ctor.newInstance(argumentList.toArray()));
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public <T> T createBean(Class<T> clazz) {
        return (T) classObjectMap.get(clazz);
    }

    @Override
    public <T> T createBean(String idOrClassName) {
        return null;
    }
}
