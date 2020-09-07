package my_spring;

import my_spring.spring.context.ApplicationContext;
import my_spring.spring.context.ClassPathJsonApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathJsonApplicationContext();
        IRobot robot = applicationContext.getBean(IRobot.class);
        robot.cleanRoom();
    }
}
