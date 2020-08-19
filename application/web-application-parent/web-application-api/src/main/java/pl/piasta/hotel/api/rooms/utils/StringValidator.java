package pl.piasta.hotel.api.rooms.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StringValidator implements ConstraintValidator<ValidateString, String> {

    private List<String> valueList;

    @Override
    public void initialize(final ValidateString constraintAnnotation) {
        valueList = Arrays.asList(constraintAnnotation.acceptedValues());
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (value != null) {
            return valueList.contains(value);
        }
        return false;
    }

}
