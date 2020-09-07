package my_spring;

import my_spring.context.ApplicationContext;
import my_spring.context.JavaConfigContext;
import my_spring.factory.ObjectFactory;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new JavaConfigContext();
        IRobot robot = applicationContext.getBean(IRobot.class);
        robot.cleanRoom();
    }
}
