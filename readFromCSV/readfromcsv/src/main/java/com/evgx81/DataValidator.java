package com.evgx81;

import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.RowValidator;

/**
 * Класс DataValidator реализует валидацию массива строк, считанного CSVReader.
 * 
 * Класс DataValidator является наследником класса RawValidator, который имеет 
 * два обязательных метода: isValid и validate. 
 * 
 * @author evgx81
 */
public class DataValidator implements RowValidator {
    /**
     * Строка, которая содержит сообщение об ошибке. 
     */
    private String message;

    /**
     * Реализуем проверку на валидацию строки и возвращаем результат. 
     * 
     * @param row массив строк, который будет проверен на валидацию
     * @return true, если строка валидная, false - в противном случае.
     */
    @Override
    public boolean isValid(String[] row) {
        // Проверяем, что массив строк содержит 6 элементов 
        if (row.length != 6) {
            message = "Row must contain only 6 columns";
            return false;
        }

        // Проверяем, что идентификатор и зарплата работника являются целочисленными
        try {
            Integer.parseInt(row[0]);
            Integer.parseInt(row[5]);
        } catch (NumberFormatException ex) {
            message = "ID and Salary must be integer";
            return false;
        }

        // Проверяем на валидацию пол работника
        if (row[2].equals("Female") && row[2].equals("Male")) {
            message = "Gender must be Male or Female";
            return false;
        }

        return true;
    }
}
