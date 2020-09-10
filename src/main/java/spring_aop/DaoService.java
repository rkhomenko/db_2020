package spring_aop;

public interface DaoService {
    <T> void save(T obj);
}
