package real_spring.aop_advanced.internal;

import lombok.SneakyThrows;
import org.springframework.aop.TargetClassAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyApplicationListener {
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("I'am started");
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            Object obj = applicationContext.getBean(beanName);
            Class<?> clazz = null;
            if (obj instanceof TargetClassAware) {
               clazz = ((TargetClassAware) obj).getTargetClass();
            } else {
                clazz = obj.getClass();
            }

            runPostProxyConstructMethods(obj, clazz);
        }
    }

    @SneakyThrows
    void runPostProxyConstructMethods(Object obj, Class<?> clazz) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostProxyConstruct.class)) {
                if (method.getParameterCount() != 0) {
                    throw new RuntimeException("Supported only no args methods");
                }
                methods.add(method);
            }
        }

        for (Method method : methods) {
            method.invoke(obj);
        }
    }
}
