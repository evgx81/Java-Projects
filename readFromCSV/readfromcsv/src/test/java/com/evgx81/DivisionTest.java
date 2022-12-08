package com.evgx81;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Unit тесты для класса Division.
 * 
 * @author evgx81
 */
public class DivisionTest 
{
    @Test
    public void correctDivisiionInitName()
    {
        Division test = new Division("Test1");

        assertEquals("Test1", test.getName());
    }

    @Test
    public void changeDivision()
    {
        Division test = new Division("Test1");
        test.setName("Test2");

        assertEquals("Test2", test.getName());
    }

    @Test
    public void checkIDOfFDifferentDivisions()
    {
        Division test1 = new Division("Test1");
        Division test2 = new Division("Test2");

        assertNotEquals(test1.getID(), test2.getID());
    }
}
