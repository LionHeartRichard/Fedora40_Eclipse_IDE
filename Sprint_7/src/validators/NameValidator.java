package validators;

import exceptions.ValidateNameException;

public class NameValidator implements Validator {

	@Override
	public void validate(String value) throws ValidateNameException {
		if (value.isEmpty())
			throw new ValidateNameException("Имя не должно быть пустым");
	}
}
