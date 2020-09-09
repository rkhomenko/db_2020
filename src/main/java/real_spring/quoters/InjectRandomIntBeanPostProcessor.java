package real_spring.quoters;

import lombok.SneakyThrows;
import my_spring.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (var field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                injectRandomInt(bean, field);
            }
        }

        return bean;
    }

    @SneakyThrows
    private void injectRandomInt(Object obj, Field field) {
        InjectRandomInt injectRandomInt = field.getAnnotation(InjectRandomInt.class);
        int randomInt = ThreadLocalRandom.current().nextInt(injectRandomInt.min(), injectRandomInt.max() + 1);

        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        field.set(obj, randomInt);
        field.setAccessible(accessible);
    }
}
