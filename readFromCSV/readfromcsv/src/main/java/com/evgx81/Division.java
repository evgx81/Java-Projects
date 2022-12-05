package com.evgx81;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс Division содержит информацию о подразделении работника.
 * 
 * @author evgx81
 */
public class Division {
    /**
     * Поле, которое позволяет реализовать сквозную генерацию ID подразделения.
     */
    transient private static AtomicInteger nextIDCounter = new AtomicInteger(1);

    /**
     *  Уникальный идентификатор подразделения.
     */
    private int ID;

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
        // Увеличивает на единицу текущее значение ID
        this.ID = nextIDCounter.getAndIncrement();
        this.name = name;
    }

     /**
     * Set и get методы для класса Division.
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
}
