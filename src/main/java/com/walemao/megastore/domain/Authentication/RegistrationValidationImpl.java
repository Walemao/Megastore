package com.walemao.megastore.domain.Authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.walemao.megastore.domain.User;


@Component("registrationValidator")
public class RegistrationValidationImpl implements RegistrationValidation
{
	private Logger logger = LoggerFactory.getLogger(RegistrationValidation.class);
	public boolean supports(Class<?> klass) 
	{
		return User.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) 
	{
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registration.userName",
				"User Name must not be Empty.");

		String userName = user.getUserName();
		logger.debug("fff" + userName);
		if ((userName.length()) > 50) 
		{
			errors.rejectValue("userName",
					"lengthOfUser.registration.userName",
					"User Name must not more than 50 characters.");
		}
		
		if (!(user.getPassword()).equals(user.getConfirmPassword())) 
		{
			errors.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}
}
