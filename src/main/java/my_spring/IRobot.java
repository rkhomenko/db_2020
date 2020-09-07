package my_spring;

import lombok.AllArgsConstructor;

/**
 * @author Evgeny Borisov
 */

@AllArgsConstructor
public class IRobot {
    private final Speaker speaker;
    private final Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("Я начал уборку");
        cleaner.clean();
        speaker.speak("Я закончил уборку");
    }
}
