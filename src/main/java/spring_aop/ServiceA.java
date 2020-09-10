package spring_aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    @Autowired
    private DaoService daoService;

    @Scheduled(fixedDelay = 1000)
    public void process() {
        daoService.save("some string");
    }
}
