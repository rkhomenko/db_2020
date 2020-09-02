package org.heroes.of.bugs.and.memleaks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hero implements Kicking {
    private String name;
    private int heatPoints;
    private int power;

    @Override
    public void kick(Hero enemyHero) {
    }
}
