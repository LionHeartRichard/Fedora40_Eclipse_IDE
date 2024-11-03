package practicum.yandex.trainer.generics.task2;

class EmploymentValidationRule extends ValidationRule<Boolean> {

	public EmploymentValidationRule(Boolean value) {
		super(value, "Ипотека выдается только трудоустроенным");
	}

	@Override
	public boolean isValid() {
		return value;
	}
}
