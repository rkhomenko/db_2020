package my_spring;

import lombok.Getter;
import my_spring.annotation.InjectRandomInt;

/**
 * @author Evgeny Borisov
 */
@Getter
public class Batman implements SuperHero {

    @InjectRandomInt
    private int power;

    @Override
    public String getName() {
        return "batman";
    }
}
