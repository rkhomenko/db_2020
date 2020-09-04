package inline_exercise;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoolRadioAlarm implements RadioAlarm {
    private Radio radio;
    private Alarm alarm;

    @Override
    public void c() {
        alarm.c();
    }

    @Override
    public void d() {
        alarm.d();
    }

    @Override
    public void a() {
        radio.a();
    }

    @Override
    public void b() {
        radio.b();
    }
}
