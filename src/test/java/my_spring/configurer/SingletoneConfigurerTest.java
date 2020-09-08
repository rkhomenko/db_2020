package my_spring.configurer;

import my_spring.Cleaner;
import my_spring.CleanerImpl;
import my_spring.ConsoleSpeaker;
import my_spring.Speaker;
import my_spring.config.JavaConfigLoader;
import my_spring.context.ApplicationContext;
import my_spring.context.MyApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletoneConfigurerTest {
    @Test
    public void testClassWihtSingletone() {
        ApplicationContext applicationContext = new MyApplicationContext(
                new JavaConfigLoader("my_spring"));
        Speaker speaker1 = applicationContext.getBean(ConsoleSpeaker.class);
        Speaker speaker2 = applicationContext.getBean(ConsoleSpeaker.class);

        assertNotNull(speaker1);
        assertNotNull(speaker2);
        assertSame(speaker1, speaker2);
    }

    @Test
    public void testClassWithoutSingleTone() {
        ApplicationContext applicationContext = new MyApplicationContext(
                new JavaConfigLoader("my_spring"));
        Cleaner cleaner1 = applicationContext.getBean(CleanerImpl.class);
        Cleaner cleaner2 = applicationContext.getBean(CleanerImpl.class);

        assertNotNull(cleaner1);
        assertNotNull(cleaner2);
        assertNotSame(cleaner1, cleaner2);
    }
}