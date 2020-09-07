package my_spring;

import my_spring.annotation.InjectRandomInt;

/**
 * @author Evgeny Borisov
 */
public class Developer {
    @InjectRandomInt(min = 20,max = -5)
    private int experience;
}
