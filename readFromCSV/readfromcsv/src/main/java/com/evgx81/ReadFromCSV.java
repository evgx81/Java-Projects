package com.evgx81;

import java.io.InputStream;

import java.util.LinkedList;
import java.util.List;

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
    }
}
