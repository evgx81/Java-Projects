package com.evgx81;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Unit тесты для класса ReadFromCSV.
 * 
 * @author evgx81
 */
public class ReadFromCSVTest {
    
    @Test
    public void testCorrectEmployee() {
        List<Employee> employees = new LinkedList<>();

        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("correct.csv");
        
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withRowValidator(new DataValidator())
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        String[] nextLine;

        try {
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(nextLine);
                employees.add(employee);
            }
        } catch (IOException exception) {
            System.out.println("Error while reading next line from file!");
        } catch (CsvValidationException exception) {
            System.out.println("Validation error in line " + 
                exception.getLineNumber() + ": " + exception.getMessage());
        }
    }

    @Test(expected = CsvValidationException.class)
    public void testIncorrectEmployeeId() throws CsvValidationException {
        List<Employee> employees = new LinkedList<>();

        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("incorrectID.csv");
        
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withRowValidator(new DataValidator())
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        String[] nextLine;

        try {
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(nextLine);
                employees.add(employee);
            }
        } catch (IOException exception) {
            System.out.println("Error while reading next line from file!");
        }
    }

    @Test(expected = CsvValidationException.class)
    public void testIncorrectEmployeeGender() throws CsvValidationException {
        List<Employee> employees = new LinkedList<>();

        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("incorrectGender.csv");
        
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withRowValidator(new DataValidator())
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        String[] nextLine;

        try {
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(nextLine);
                employees.add(employee);
            }
        } catch (IOException exception) {
            System.out.println("Error while reading next line from file!");
        }
    }

    @Test(expected = CsvValidationException.class)
    public void testIncorrectEmployeeSalary() throws CsvValidationException {
        List<Employee> employees = new LinkedList<>();

        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("incorrectSalary.csv");
        
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withRowValidator(new DataValidator())
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        String[] nextLine;

        try {
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(nextLine);
                employees.add(employee);
            }
        } catch (IOException exception) {
            System.out.println("Error while reading next line from file!");
        }
    }

    @Test(expected = CsvValidationException.class)
    public void testIncorrectEmployeeLengthLess() throws CsvValidationException {
        List<Employee> employees = new LinkedList<>();

        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("incorrectRawLengthLess.csv");
        
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withRowValidator(new DataValidator())
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        String[] nextLine;

        try {
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(nextLine);
                employees.add(employee);
            }
        } catch (IOException exception) {
            System.out.println("Error while reading next line from file!");
        }
    }

    @Test(expected = CsvValidationException.class)
    public void testIncorrectEmployeeLengthMore() throws CsvValidationException {
        List<Employee> employees = new LinkedList<>();

        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("incorrectRawLengthMore.csv");
        
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withRowValidator(new DataValidator())
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        String[] nextLine;

        try {
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(nextLine);
                employees.add(employee);
            }
        } catch (IOException exception) {
            System.out.println("Error while reading next line from file!");
        }
    }
}
