package org.heroes.of.bugs.and.memleaks;

import java.util.concurrent.ThreadLocalRandom;

public class King extends Hero implements Kicking {
    public King(String name) {
        setName(name);
        setHeatPoints(ThreadLocalRandom.current().nextInt(5, 16));
        setPower(ThreadLocalRandom.current().nextInt(5, 16));
    }

    @Override
    public void kick(Hero enemyHero) {
        int enemyHeatPoints = enemyHero.getHeatPoints();
        int kickPower = ThreadLocalRandom.current().nextInt(0, getPower() + 1);

        System.out.printf("Король \"%s\" накатывает обновление на билд сервер \"%s\". Билды больше не проходят (-%d к зарплате)",
                getName(), enemyHero.getName(), kickPower);

        if (enemyHeatPoints - kickPower < 0) {
            enemyHero.setHeatPoints(0);
        } else {
            enemyHero.setHeatPoints(enemyHeatPoints - kickPower);
        }
    }
}
