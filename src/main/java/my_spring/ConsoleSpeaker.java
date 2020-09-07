package my_spring;

import my_spring.annotation.Singleton;

/**
 * @author Evgeny Borisov
 */

@Singleton
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
