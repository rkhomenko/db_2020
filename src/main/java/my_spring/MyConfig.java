package my_spring;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Evgeny Borisov
 */

@my_spring.annotation.JavaConfig
@Getter
@RequiredArgsConstructor
public class MyConfig {
    public Cleaner getCleaner(CleanerImpl cleaner) {
        return cleaner;
    }

    public Speaker getSpeaker(ConsoleSpeaker speaker) {
        return speaker;
    }
}
