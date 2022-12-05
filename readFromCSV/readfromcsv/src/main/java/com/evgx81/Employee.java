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
     * Конструктор с параметром для класса Employee.
     * 
     * @param data массив строк, который содержит считанные элементы одной строки файла.
     */
    public Employee(String[] data) {
        this.ID = Integer.parseInt(data[0]);
        this.name = data[1];
        this.gender = data[2].equals("Female") ? Gender.FEMALE : Gender.MALE;
        this.birthDay = data[3];

        // Если в хэш-таблице содержится данное подразделения, то заполняем поле подразделения
        // значением уже созданного подразделения из хэш-таблицы.
        // В противном случае создаем новое подразделение и добавляем его в хэш-таблицу.
        String division = data[4];
        if (createdDivisions.containsKey(division)) {
            this.division = createdDivisions.get(division);
        }
        else {
            Division newDivision = new Division(division);
            createdDivisions.put(division, newDivision);
            this.division = newDivision;
        }
    
        this.salary = Integer.parseInt(data[5]);
    }

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