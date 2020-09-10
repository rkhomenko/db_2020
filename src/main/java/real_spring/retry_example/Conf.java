package real_spring.retry_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
@EnableRetry
@EnableAspectJAutoProxy
public class Conf {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        ProblemService problemService = context.getBean(ProblemService.class);
        problemService.doWork();
    }
}
