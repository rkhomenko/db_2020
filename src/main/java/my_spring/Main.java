package my_spring;

import my_spring.config.JavaConfigLoader;
import my_spring.context.ApplicationContext;
import my_spring.context.MyApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyApplicationContext(
                new JavaConfigLoader("my_spring"));

        IRobot robot = applicationContext.getBean(IRobot.class);
        robot.cleanRoom();
    }
}
