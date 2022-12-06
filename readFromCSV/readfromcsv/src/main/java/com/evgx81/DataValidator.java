package com.evgx81;

import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.RowValidator;

/**
 * Класс DataValidator реализует валидацию массива строк, считанного CSVReader.
 * 
 * Класс DataValidator является наследником класса RawValidator, который имеет 
 * два обязательных метода: isValid и validate. 
 * s
 * @author evgx81
 */
public class DataValidator implements RowValidator {
    /**
     * Строка, которая содержит сообщение об ошибке. 
     */
    private String message;
}
