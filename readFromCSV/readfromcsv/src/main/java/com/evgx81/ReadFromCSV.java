package com.evgx81;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;

import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.CSVReader;

/**
 * Класс ReadFromCSV реализует чтение из csv файла и заполнение листа считанными данными.
 * 
 * @author evgx81
 */
public class ReadFromCSV 
{
    /**
     * Лист, который впоследствии будет заполнен считанными данными.
     */
    private static List<Employee> employees = new LinkedList<>();

    public static void main(String[] args)
    {
        // Открываем файл для чтения
        InputStream fileStream = ReadFromCSV.class.getClassLoader().getResourceAsStream("foreign_names.csv");
        if (fileStream == null) {
            System.out.println("Error: resource file not found!");
            return;
        }

        // Создаем объект, с помощью которого будем считывать строки из файла
        // Пропускаем первую строку файла и начинаем чтение со второй строки файла
        // Сепаратором является ;
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(fileStream))
                                    .withSkipLines(1)
                                    .withCSVParser(new CSVParserBuilder()
                                            .withSeparator(';')
                                            .build())
                                    .build();

        // Создаем пустой массив строк
        String[] nextLine;

        // Считываем каждую строку в массив строк
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

        System.out.println("Reading completed!");
        System.out.println("List contains " + employees.size() + " elements!");
    }
}
