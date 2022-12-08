package com.evgx81;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;



/**
 * Unit тесты для класса Employee.
 * 
 * @author evgx81
 */
public class EmployeeTest {
    
    @Test
    public void testCreatedEmployeeID() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals("ID should be initialized", 1, empl_test.getID());
    }

    @Test
    public void testCreatedEmployeeName() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals("Employee1", empl_test.getName());
    }

    @Test
    public void testCreatedEmployeeGenderMale() {
        String[] test = {"1", "Employee1", "Male", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(Gender.MALE, empl_test.getGender());
    }
    
    @Test
    public void testCreatedEmployeeGenderFemale() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(Gender.FEMALE, empl_test.getGender());
    }

    @Test
    public void testCreatedEmployeeBirthDay() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getBirthDay(), "10.11.1978");
    }

    @Test
    public void testCreatedEmployeeDivisionName() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals("G", empl_test.getDivision().getName());
    }

    @Test
    public void createdEmployeesWithDifferentDivisions() {
        String[] test1 = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        String[] test2 = {"2", "Employee2", "Female", "11.12.1878", "L", "15000"};

        Employee empl_test1 = new Employee(test1);
        Employee empl_test2 = new Employee(test2);

        assertNotSame(empl_test1.getDivision(), empl_test2.getDivision());
    }

    @Test
    public void createdEmployeesWithSameDivisions() {
        String[] test1 = {"1", "Employee1", "Female", "10.11.1978", "L", "1500"};
        String[] test2 = {"2", "Employee2", "Female", "11.12.1878", "L", "15000"};

        Employee empl_test1 = new Employee(test1);
        Employee empl_test2 = new Employee(test2);

        assertSame(empl_test1.getDivision(), empl_test2.getDivision());
    }

    @Test
    public void testCreatedEmployeeSalary() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getSalary(), (Integer) 1500);
    }
}
