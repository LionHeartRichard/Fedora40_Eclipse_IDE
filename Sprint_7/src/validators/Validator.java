package validators;

import exceptions.ValidateException;

public interface Validator {
	void validate(String value) throws ValidateException;
}
