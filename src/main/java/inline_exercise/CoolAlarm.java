package inline_exercise;

public class CoolAlarm implements Alarm {
    @Override
    public void c() {
        System.out.println("Будильник: запущен метод c()");
    }

    @Override
    public void d() {
        System.out.println("Будильник: запущен метод d()");
    }
}
