package ru.yandex.practicum.sprint10;

import java.lang.annotation.*;

//мета-аннотация @Target указывает, что аннотация применима к методам
@Target(ElementType.METHOD)
//мета-аннотация @Retention указывает, что информация об аннотации будет доступна во время выполнения
@Retention(RetentionPolicy.RUNTIME)
//мета-аннотация @Repeatable указывает на класс-контейнер для повторяющихся аннотаций
@Repeatable(LoggableContainer.class)
@interface Loggable {
	String value() default "Лог по умолчанию";
}

//контейнерная аннотация для повторяющейся аннотации Loggable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LoggableContainer {
	Loggable[] value();
}

public class Service {

	// применяем аннотацию @Loggable к методу
	@Loggable("Пользовательский лог")
	public void performAction() {
		// логика метода
		System.out.println("Действие выполнено!");
	}

	// повторное применение аннотации Loggable, ведь она отмечена мета-аннотацией
	// @Repeatable
	@Loggable("Пользовательский лог")
	@Loggable("Повторный пользовательский лог")
	public void additionalAction() {
		// логика метода
		System.out.println("Дополнительное действие выполнено!");
	}

	public void nonLoggedAction() {
		// логика метода без аннотации
		System.out.println("Действие без логирования!");
	}
}
