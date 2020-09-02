package org.heroes.of.bugs.and.memleaks;

public class GameManager {
    public void fight(Hero hero1, Hero hero2) {
        while (hero1.getHeatPoints() > 0 && hero2.getHeatPoints() > 0) {
            hero1.kick(hero2);
            hero2.kick(hero1);
        }
    }
}
