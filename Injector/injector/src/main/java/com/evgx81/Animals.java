package com.evgx81;

/**
 * Класс Animals содержит 2 неинициализированных поля, помеченных аннатоцацией AutoInjectable.
 * 
 * @author evgx81
 */
public class Animals {
    @AutoInjectable
    private Mammal mammal;

    @AutoInjectable
    private Bird bird;

    /**
     * Функция, которая выводит в консоль звук млекопитающего и птицы.
     */
    public void noise() {
        mammal.say();
        bird.sing();
    }
}
