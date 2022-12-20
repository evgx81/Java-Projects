package com.evgx81;

public class Main 
{
    public static void main(String[] args)
    {
        // Создаем объект класса Injector 
        Injector injector = new Injector();
        // Загружаем считанные свойства из файла
        injector.loadProperties("src/main/resources/config.properties");

        Animals animals = (Animals) injector.inject(new Animals());
        animals.noise();
    }
}
