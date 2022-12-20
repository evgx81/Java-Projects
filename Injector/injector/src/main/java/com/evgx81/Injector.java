package com.evgx81;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс Injector демонстрирует механизм инициализации полей с помощью рефлексии.
 * 
 * @author evgx81
 */
public class Injector {
    /**
     * Хэш-таблица, которая будет хранить считанные из файла свойства.
     */
    private Properties props = new Properties();

    /**
     * Функция считывания данных из файла.
     */
    public void loadProperties(String path) {
    
        try {
            // Создаем объект для чтения файла настроек (properties)
            FileInputStream fs = new FileInputStream(path);
            // Считываем данные из файла настроек
            props.load(fs);

        } catch (IOException exception) {
            System.err.println("Error: properties file not found!");
            exception.printStackTrace(System.err);
        }
    } 

    public Object inject(Object obj) {
        // Просматриваем все поля класса объекта
        for (Field field : obj.getClass().getDeclaredFields()) {

            if (!field.isAnnotationPresent(AutoInjectable.class)) {
                continue;
            }

            // Получаем имя типа поля
            String interfaceName = field.getType().getName();
            String className = props.getProperty(interfaceName);

            // Создаем объект, который будет инициализировать поле
            Object classObject;
            try {
                classObject = Class.forName(className).getDeclaredConstructor().newInstance();
            } catch (Throwable ex) {
                ex.printStackTrace();
                continue;
            }
            
            // Устанавливаем значение поля
            field.setAccessible(true);
            try {
                field.set(obj, classObject);
            } catch (IllegalAccessException ex) {
                System.err.println("Невозможно инициализировать поле так, как к нему нет доступа!");
                continue;
            } 
        }

        return obj;
    }
}
