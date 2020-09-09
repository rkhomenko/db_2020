package homework.never_use_switch;

import com.github.javafaker.Faker;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Faker getFaker() {
        return new Faker();
    }

    @Bean
    public DataFactory getDataFactory() {
        return new DataFactory();
    }
}
