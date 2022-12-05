package com.evgx81;

import java.util.HashMap;

/**
 * Класс Employee содержит информацию о работнике.
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

    /**
     * Хэш-таблица для хранения пар: ("Название подразделения" - "Подразделение").
     */
    private static HashMap<String, Division> createdDivisions = new HashMap<>();

    /**
     * Set и get методы для класса Employee.
     */
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public Division getDivision() {
        return division;
    }
    
    public void setDivision(Division division) {
        this.division = division;
    }
    
    public Integer getSalary() {
        return salary;
    }
    
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
    public String getBirthDay() {
        return birthDay;
    }
    
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
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