package real_spring.aop_advanced.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import real_spring.aop_advanced.internal.PostProxyConstruct;

/**
 * @author Evgeny Borisov
 */
@Service
public class ServiceA {
    @Autowired
    private ServiceB serviceB;

    @PostProxyConstruct
    public void doA() {
        System.out.println("AAAAAAAAA");
        try {
            serviceB.doB();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Очень жаль...");
        }
        System.out.println("продолжаем работать");
    }
}
