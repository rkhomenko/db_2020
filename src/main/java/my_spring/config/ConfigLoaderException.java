package my_spring.config;

public class ConfigLoaderException extends RuntimeException {
    public ConfigLoaderException() {
        super();
    }

    public ConfigLoaderException(String message) {
        super(message);
    }
}
