package pl.piasta.hotel.api.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StringValidator implements ConstraintValidator<ValidateString, String> {

    private List<String> acceptedValues;

    @Override
    public void initialize(final ValidateString constraintAnnotation) {
        acceptedValues = Arrays.asList(constraintAnnotation.acceptedValues());
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        return value != null && acceptedValues.stream().anyMatch(acceptedValue -> acceptedValue.equalsIgnoreCase(value));
    }

}
