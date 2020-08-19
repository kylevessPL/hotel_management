package pl.piasta.hotel.api.rooms.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<ValidateEnum, Object> {

    private Object[] enumValues;

    @Override
    public void initialize(final ValidateEnum annotation) {
        enumValues = annotation.enumClass().getEnumConstants();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        if (value != null) {
            String contextValue = value.toString();
            return Arrays.stream(enumValues).anyMatch(enumValue -> enumValue.toString().equals(contextValue));
        }
        return false;
    }

}
