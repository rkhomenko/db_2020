package org.heroes.of.bugs.and.memleaks;

public class Elf extends Hero implements Kicking {
    public Elf(String name) {
        setName(name);
        setHeatPoints(10);
        setPower(10);
    }

    @Override
    public void kick(Hero enemyHero) {
        int enemyPower = enemyHero.getPower();

        if (enemyPower <= getPower()) {
            System.out.printf("Эльф \"%s\" находит бак в коде \"%s\", вызывая увольнение\n",
                    getName(),
                    enemyHero.getName());
            enemyHero.setHeatPoints(0);
        } else {
            System.out.printf("Эльф \"%s\" кастует memleak в процесс \"%s\" (-1 к зарплате)\n",
                    getName(),
                    enemyHero.getName());
            enemyHero.setPower(enemyPower - 1);
        }
    }
}
