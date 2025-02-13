package ru.yandex.practicum.sprint10.tasks;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CorrectImplementation {
	Class<?> expectedReturnType() default void.class;
	Class<?>[] expectedParameterTypes();
}

class AnnotationValidator {

	public static void validateMethods(Object instance) {

    Class<?> clazz = instance.getClass();

    for (Method method: clazz.getMethods()) {
      if (method.isAnnotationPresent(CorrectImplementation.class)) {
    	  CorrectImplementation annotation = method.getAnnotation(CorrectImplementation.class);

        Class<?> expectedReturnType = annotation.expectedReturnType();
        Class<?>[] expectedParameterTypes = annotation.expectedParameterTypes();

        // проверяем, соответствует ли фактический возвращаемый тип ожидаемому
        if (!method.getReturnType().equals(expectedReturnType)) {
          // выводим сообщение об ошибке
          System.out.println(
                "Ошибка: Метод " + method.getName()
                        + " имеет неправильный тип возвращаемого значения (" + method.getReturnType() + ")." +
                        " Ожидаемый: " + expectedReturnType.getSimpleName());
          // ничего не возвращаем, так как мы не ожидаем результата валидации
          return;
        }

        // получаем фактические типы параметров
        Class<?>[] actualParameterTypes = method.getParameterTypes();

        // проверяем, соответствуют ли фактические типы параметров ожидаемым
        if (!Arrays.equals(expectedParameterTypes, actualParameterTypes)) {
          // выводим сообщение об ошибке
          System.out.println(
              "Ошибка: Метод "
                  + method.getName()
                  + " имеет неправильные типы параметров. Ожидаемые:"
                  + Arrays.toString(expectedParameterTypes));
          // ничего не возвращаем, так как мы не ожидаем результата валидации
          return;
        }
      }
    }

    // выводим сообщение об успешной валидации
    System.out.println("Все методы реализованы корректно.");
    // ничего не возвращаем, так как мы не ожидаем результата валидации
  }
}

public class MathOperations {
	// метод для сложения
	@CorrectImplementation(expectedReturnType=int.class,expectedParameterTypes = {int.class, int.class})
	public int add(int a, int b) {
		return a + b;
	}

	@CorrectImplementation(expectedReturnType=double.class,expectedParameterTypes = {double.class, double.class})
	public double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Невозможно разделить на ноль");
		}
		return a / b;
	}

	@CorrectImplementation(expectedReturnType=double.class,expectedParameterTypes = {double.class, double.class})
	public double multiply(double a, double b) {
		return a * b;
	}

	public static void main(String[] args) {
    MathOperations mathOperations = new MathOperations();
    // вызываем метод валидации аннотаций
    AnnotationValidator.validateMethods(mathOperations);
  }
}
