package ru.yandex.practicum.sprint10.introdactionannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// создаём аннотацию для описания полей
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldDescription {
    String value() default "";
}

public class User {
    // аннотируем поле, добавляя описание к имени пользователя
    @FieldDescription("Имя пользователя")
    private String username;

    // аннотируем поле, добавляя описание к электронной почте пользователя
    @FieldDescription("Электронная почта пользователя")
    private String email;
    
    private int age;

    public static void main(String[] args) {
        // получаем класс пользователя
        Class<?> userClass = User.class;

        // получаем все поля класса с использованием рефлексии
        Field[] fields = userClass.getDeclaredFields();

        // проходимся по всем полям
        for (Field field : fields) {
            // проверяем, аннотировано ли поле созданной аннотацией, с помощью рефлексии
            if (field.isAnnotationPresent(FieldDescription.class)) {
                FieldDescription annotation = field.getAnnotation(FieldDescription.class);
                // выводим информацию о поле и его описании
                System.out.println("Поле: " + field.getName());
                System.out.println("Описание: " + annotation.value());
                System.out.println(); // добавим пустую строку для разделения полей при выводе
            }
        }
    }
} 
