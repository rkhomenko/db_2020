package spring_aop;

public class DatabaseRuntimeException extends RuntimeException {
    public DatabaseRuntimeException() {
        super();
    }

    public DatabaseRuntimeException(String message) {
        super(message);
    }
}
