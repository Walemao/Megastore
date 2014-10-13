package com.walemao.megastore.domain.Authentication;

import org.springframework.validation.Errors;

public interface RegistrationValidation {

	public void validate(Object target, Errors errors);
}
