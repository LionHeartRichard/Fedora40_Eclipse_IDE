package com.yandexpracticum.main.workbystring;

class TextEditor {

	private boolean isCapsLock = false;

	public void capsLock() {
		// Здесь нужно изменить значение флага isCapsLock на противоположное
		isCapsLock = !isCapsLock;
	}

	public void print(String str) {
		// а здесь нужно распечатать строку или в верхнем регистре, или без изменений,
		// учитывая флаг
		if (isCapsLock) {
			System.out.println(str.toUpperCase());
		} else {
			System.out.println(str);
		}
	}
}
