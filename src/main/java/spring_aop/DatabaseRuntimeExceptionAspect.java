package spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DatabaseRuntimeExceptionAspect {
    @Autowired
    Mailer mailer;

    @AfterThrowing(pointcut = "execution(* spring_aop.*.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint jp, DatabaseRuntimeException ex) {
        mailer.send(ex);
    }
}