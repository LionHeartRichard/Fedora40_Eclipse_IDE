package ru.yandex.practicum.sprint10.introdactionannotation;

public @interface ObjectInfo {
	Class<?> type() default Object.class;

	Class<?>[] args() default {};

	boolean required() default false;
}
