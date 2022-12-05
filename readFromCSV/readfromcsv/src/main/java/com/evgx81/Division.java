package com.evgx81;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс Division содержит информацию о подразделении работника.
 * 
 * @author evgx81
 */
public class Division {
    transient private static AtomicInteger nextIDCounter = new AtomicInteger(1);

    /**
     *  Уникальный идентификатор подразделения.
     */
    private int id;

    /**
     *  Название подразделения.
     */
    private String name;

    /**
     * Конструктор для класса Division.
     * 
     * @param name название подразделения.
     */
    public Division(String name) {
        this.id = nextIDCounter.getAndIncrement();
        this.name = name;
    }

     /**
     * Set и get методы для класса Division.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
