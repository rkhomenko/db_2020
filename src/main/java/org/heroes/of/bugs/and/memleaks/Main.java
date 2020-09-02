package org.heroes.of.bugs.and.memleaks;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = HeroFactory.createHero("Hero1");
        Hero hero2 = HeroFactory.createHero("Hero2");

        if (hero1 == null || hero2 == null) {
            System.exit(-1);
        }

        while (hero1.getClass().equals(hero2.getClass())) {
            hero1 = HeroFactory.createHero("Hero1");
            hero2 = HeroFactory.createHero("Hero2");

            if (hero1 == null || hero2 == null) {
                System.exit(-1);
            }
        }


        while (hero1.getHeatPoints() > 0 && hero2.getHeatPoints() > 0) {
            hero1.kick(hero2);
            hero2.kick(hero1);
        }
    }
}
