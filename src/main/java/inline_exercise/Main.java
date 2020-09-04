package inline_exercise;

public class Main {
    public static void main(String[] args) {
        // It might be beans in Spring
        Radio radio = new CoolRadio();
        Alarm alarm = new CoolAlarm();
        // Need dependency injection here
        RadioAlarm radioAlarm = new CoolRadioAlarm(radio, alarm);
        radioAlarm.a();
        radioAlarm.b();
        radioAlarm.c();
        radioAlarm.d();
    }
}
