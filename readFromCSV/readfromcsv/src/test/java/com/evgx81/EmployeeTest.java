package com.evgx81;

import static org.junit.Assert.assertEquals;

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

        assertEquals(empl_test.getID(), 1);
    }

    @Test
    public void testCreatedEmployeeName() {
        String[] test = {"1", "Employee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getName(), "Employee1");
    }
    
    @Test
    public void testCreatedEmployeeGender() {
        String[] test = {"1", "Emplyee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getGender(), Gender.FEMALE);
    }

    @Test
    public void testCreatedEmployeeBirthDay() {
        String[] test = {"1", "Emplyee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getBirthDay(), "10.11.1978");
    }

    @Test
    public void testCreatedEmployeeDivisionName() {
        String[] test = {"1", "Emplyee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getDivision().getName(), "G");
    }

    @Test
    public void testCreatedEmployeeSalary() {
        String[] test = {"1", "Emplyee1", "Female", "10.11.1978", "G", "1500"};
        Employee empl_test = new Employee(test);

        assertEquals(empl_test.getSalary(), (Integer) 1500);
    }
}
