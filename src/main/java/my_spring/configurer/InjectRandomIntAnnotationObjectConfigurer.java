package my_spring.configurer;

import heroes.RandomUtil;
import lombok.SneakyThrows;
import my_spring.annotation.InjectRandomInt;
import my_spring.configurer.ObjectConfigurer;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        Field[] fields = implClass.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int randomInt = RandomUtil.getIntBetween(annotation.min(), annotation.max());
                field.setAccessible(true);
                field.setInt(t, randomInt);
            }
        }
    }
}
