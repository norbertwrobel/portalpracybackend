package com.example.wsb.security.auth;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class RegisterRequestValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest registerRequest = (RegisterRequest) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required", "First Name must not be empty.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required", "Last Name must not be empty.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "field.required", "Login must not be empty.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Password must not be empty.");
        if (registerRequest.getPassword().length() < 8) {
            errors.rejectValue("password", "field.minLength", new Object[]{8}, "Password must be at least 8 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Email must not be empty.");
        if (!registerRequest.getEmail().matches("[\\w.-]+@[\\w.-]+")) {
            errors.rejectValue("email", "field.invalid", new Object[]{registerRequest.getEmail()}, "Email must be a well-formed email address.");
        }
    }
}
