package my_spring;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {


        Map<Class<?>, Class<?>> map = Map.of(
                Speaker.class, ConsoleSpeaker.class
                );


        // Need refactoring here
        ObjectFactory.getInstance().setConfig(new JavaConfig(map,"my_spring") {
        });

        ApplicationContext applicationContext = new MyApplicationContext();
        IRobot iRobot = applicationContext.getBean(IRobot.class);
        iRobot.cleanRoom();
    }
}
