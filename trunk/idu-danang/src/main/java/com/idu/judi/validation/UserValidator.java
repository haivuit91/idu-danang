package com.idu.judi.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.idu.judi.model.User;

@Component
public class UserValidator implements Validator {

	private final static String EMPLOYEES_NAME = "userName";

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		String userName = user.getUserName();

		if (userName != null && userName.length() < 4)
			errors.rejectValue(EMPLOYEES_NAME, "User name wrong!");

	}

}