package real_spring.aop_advanced.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.aop.TargetClassAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@AllArgsConstructor
@Getter
class Pair<L, R> {
    private final L left;
    private final R right;
}

@Component
public class MyApplicationListener {
    private List<Pair<Object, List<Method>>> objectMethodList = new ArrayList<>();

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

            putPostProxyConstructMethods(obj, clazz);
        }

        runMethodsInParallel();
    }

    @SneakyThrows
    private void putPostProxyConstructMethods(Object obj, Class<?> clazz) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostProxyConstruct.class)) {
                if (method.getParameterCount() != 0) {
                    throw new RuntimeException("Supported only no args methods");
                }
                methods.add(method);
            }
        }

        if (methods.size() != 0) {
            objectMethodList.add(new Pair<>(obj, methods));
        }
    }

    @SneakyThrows
    private void runMethodsInParallel() {
        objectMethodList.parallelStream().forEach(MyApplicationListener::runMethods);
    }

    @SneakyThrows
    private static void runMethods(Pair<Object, List<Method>> pair) {
        Object obj = pair.getLeft();
        List<Method> methods = pair.getRight();
        for (Method method : methods) {
            method.invoke(obj); 
        }
    }
}
