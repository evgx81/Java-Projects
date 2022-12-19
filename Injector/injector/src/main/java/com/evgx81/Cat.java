package com.evgx81;

/**
 * Класс Rooster реализует интерфейс Cat.
 * 
 * @author evgx81
 */
public class Cat implements Mammal {

    @Override
    public void say() {
        System.out.println("Мяу!");
    }
}
