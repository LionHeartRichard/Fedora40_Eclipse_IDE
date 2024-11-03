package practicum.yandex.trainer.generics.task2;

class AgeValidationRule extends ValidationRule<Byte> {

	public AgeValidationRule(Byte age) {
		super(age, "Возраст для подачи на ипотеку должен быть старше 18 лет");
	}

	@Override
	public boolean isValid() {
		return value >= 18;
	}

}
