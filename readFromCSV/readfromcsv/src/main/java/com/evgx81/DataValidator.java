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
     * 
     */
    @Override
    public boolean isValid(String[] row) {
        if (row.length != 6) {
            message = "Row must contain only 6 columns";
            return false;
        }

        try {
            Integer.parseInt(row[0]);
            Integer.parseInt(row[5]);
        } catch (NumberFormatException ex) {
            message = "ID and Salary must be integer";
            return false;
        }

        if (row[2].equals("Female") && row[2].equals("Male")) {
            message = "Gender must be Male or Female";
            return false;
        }

        return true;
    }
}
