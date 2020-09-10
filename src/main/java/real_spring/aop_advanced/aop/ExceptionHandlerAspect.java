package real_spring.aop_advanced.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import real_spring.aop_advanced.services.DBRuntimeException;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
@PropertySource("application.properties")
public class ExceptionHandlerAspect {
    private final List<String> dbaEmails;

    public ExceptionHandlerAspect(@Value("${dba.emails}") List<String> emails) {
        dbaEmails = emails;
    }

    @AfterThrowing(pointcut = "@target(org.springframework.stereotype.Repository) && execution(* real_spring.aop_advanced..*.*(..))",
            throwing = "ex")
    public void handleDbException(DBRuntimeException ex) {
        System.out.println("sending mails " + dbaEmails);
    }
}
