package com.evgx81;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Unit-тесты для класса Injector.
 * 
 * @author evgx81
 */
public class InjectorTest 
{
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testCatRooster() {

        Injector injector = new Injector();
        injector.loadProperties("src/test/resources/CatRooster.properties");
        Animals animals = (Animals) injector.inject(new Animals());

        animals.noise();

        assertEquals("Мяу!\r\nКу-ка-ре-ку!\r\n", systemOutRule.getLog());
    }

    @Test
    public void testCatSparrow() {

        Injector injector = new Injector();
        injector.loadProperties("src/test/resources/CatSparrow.properties");
        Animals animals = (Animals) injector.inject(new Animals());

        animals.noise();

        assertEquals("Мяу!\r\nЧик-чирик!\r\n", systemOutRule.getLog());
    }


    @Test
    public void testDogRooster() {

        Injector injector = new Injector();
        injector.loadProperties("src/test/resources/DogRooster.properties");
        Animals animals = (Animals) injector.inject(new Animals());

        animals.noise();

        assertEquals("Гав-гав!\r\nКу-ка-ре-ку!\r\n", systemOutRule.getLog());
    }

    @Test
    public void testDogSparrow() {

        Injector injector = new Injector();
        injector.loadProperties("src/test/resources/DogSparrow.properties");
        Animals animals = (Animals) injector.inject(new Animals());

        animals.noise();

        assertEquals("Гав-гав!\r\nЧик-чирик!\r\n", systemOutRule.getLog());
    }
}
