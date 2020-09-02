package org.heroes.of.bugs.and.memleaks;

public class Hobbit extends Hero implements Kicking {
    public Hobbit(String name) {
        setName(name);
        setHeatPoints(3);
        setPower(0);
    }

    @Override
    public void kick(Hero enemyHero) {
        System.out.println("Хоббит: использовать GDB и Valgrind на многопоточном приложении больно. Плак-плак\n");
    }
}
