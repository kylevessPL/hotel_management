package pl.piasta.hotel.api.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StringArrayValidator implements ConstraintValidator<ValidateStringArray, String[]> {

    private List<String> acceptedValues;

    @Override
    public void initialize(final ValidateStringArray constraintAnnotation) {
        acceptedValues = Arrays.asList(constraintAnnotation.acceptedValues());
    }

    @Override
    public boolean isValid(final String[] values, final ConstraintValidatorContext context) {
        if (values != null) {
            for(String value : values) {
                if (acceptedValues.stream().noneMatch(acceptedValue -> acceptedValue.equalsIgnoreCase(value)))
                    return false;
            }
            return true;
        }
        return false;
    }

}
