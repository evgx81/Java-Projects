package com.evgx81;

import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.RowValidator;

/**
 * Класс DataValidator реализует валидацию массива строк, считанного CSVReader.
 * 
 * @author evgx81
 */
public class DataValidator implements RowValidator {
    /**
     * Строка, которая содержит сообщение об ошибке. 
     */
    private String message;
}
