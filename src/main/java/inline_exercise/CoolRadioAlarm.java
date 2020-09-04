package inline_exercise;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

@AllArgsConstructor
public class CoolRadioAlarm implements RadioAlarm {
    @Delegate
    private Radio radio;
    @Delegate
    private Alarm alarm;
}
