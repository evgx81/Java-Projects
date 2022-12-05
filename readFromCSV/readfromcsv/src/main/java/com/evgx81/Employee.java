package com.evgx81;

/**
 * Класс Person содержит информацию о работнике.
 * 
 * @author evgx81
 */
public class Employee {
    /**
     *  Уникальный идентификатор работника.
     */
    private int ID;

    /**
     *  Имя работника.
     */
    private String name;

    /** 
     * Пол работника.
     */
    private Gender gender;

    /**
     * Дата рождения работника.
     */
    private Division division;

    /**
     * Подразделение работника.
     */
    private int salary;

    /**
     * Зарплата работника.
     */
    private String birthDay;

   
}

/**
 * Класс Gender содержит информацию о поле работника.
 * 
 * @author evgx81
 */
enum Gender {
    MALE,
    FEMALE
}