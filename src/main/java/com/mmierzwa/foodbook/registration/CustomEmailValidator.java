package com.mmierzwa.foodbook.registration;

import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.function.Predicate;

@Service
public class CustomEmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return EmailValidator.getInstance().isValid(s);
    }
}
