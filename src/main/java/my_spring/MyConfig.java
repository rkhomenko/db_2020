package my_spring;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import my_spring.annotation.JavaConfig;

/**
 * @author Evgeny Borisov
 */

@JavaConfig
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
