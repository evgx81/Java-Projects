package com.evgx81;

/**
 * Класс Bird является базовым для классов Rooster и Sparrow.
 * В производных классах будет переопределяться метод sing. 
 * 
 * @author evgx81
 */
public interface Bird {
    /**
     * Функция, которая характеризует звук, который издает птица.
     */
    public void sing();
}
