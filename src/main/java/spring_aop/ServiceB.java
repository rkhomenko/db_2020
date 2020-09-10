package spring_aop;

import org.springframework.stereotype.Service;

@Service
public class ServiceB implements DaoService {
    @Override
    public <T> void save(T obj) {
        System.out.println("Save obj to db");
        throw new RuntimeException("Fail");
    }
}
