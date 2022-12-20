package com.evgx81;

public class Main 
{
    public static void main(String[] args)
    {
        // Создаем объект класса Injector и считываем свойства из файла
        Injector injector = new Injector("src/main/resources/config.properties");

        Animals animals = (Animals) injector.inject(new Animals());
        animals.noise();
    }
}
