package my_spring;

import my_spring.config.JavaConfigLoader;
import my_spring.factory.ObjectFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactoryTest {
    private static ObjectFactory factory;

    @BeforeClass
    public static void initTest() {
        factory = new ObjectFactory(new JavaConfigLoader("my_spring"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void injectRandomIntForIncorrectValuesIsFailing() {
        factory.createObject(Developer.class);
    }

    @Test
    public void injectRandomIntIsWorking() {

        Soldier soldier = factory.createObject(Soldier.class);
        Assert.assertTrue(soldier.getPower() < 15 && soldier.getPower() > 7);
    }

    @Test
    public void objectWasCreatedFromConfiguredClass() {


        // TODO: Fix this
//        Config config = Mockito.mock(Config.class);
//
//        Mockito.when(config.getImpl(SuperHero.class)).then(invocation -> Batman.class);
//
//
//        ObjectFactory.getInstance().setConfig(config);
//        SuperHero superHero = ObjectFactory.getInstance().createObject(SuperHero.class);
//        Assert.assertEquals(Batman.class, superHero.getClass());
    }
}























