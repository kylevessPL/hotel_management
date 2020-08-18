package pl.piasta.hotel.api.rooms.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidateEnum, Object> {

    private Object[] enumValues;

    @Override
    public void initialize(final ValidateEnum annotation) {
        enumValues = annotation.enumClass().getEnumConstants();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        if (null != value) {
            String contextValue = value.toString();

            for (Object enumValue : enumValues) {
                if (enumValue.toString().equals(contextValue)) {
                    return true;
                }
            }
        }
        return false;
    }

}
