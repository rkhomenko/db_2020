package org.heroes.of.bugs.and.memleaks;

import java.lang.reflect.Constructor;
import java.util.concurrent.ThreadLocalRandom;

public class HeroFactory {
    private static final Class<?>[] heroesClasses = {
            Hobbit.class,
            Elf.class,
            King.class
    };

    public static Hero createHero(String name) {
        int randomIdx = ThreadLocalRandom.current().nextInt(0, heroesClasses.length);
        Class<?> heroClass = heroesClasses[randomIdx];

        Hero hero = null;
        try {
            Constructor<?> ctor = heroClass.getConstructor(String.class);
            hero = (Hero) ctor.newInstance(name);
        } catch (Exception e) {
            return null;
        }

        return hero;
    }
}
