package com.evgx81;

/**
 * Класс Cat реализует интерфейс Mammal.
 * 
 * @author evgx81
 */
public class Cat implements Mammal {

    @Override
    public void say() {
        System.out.println("Мяу!");
    }
}
