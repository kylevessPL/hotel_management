package pl.piasta.hotel.api.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = StringValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidateString {

    String[] acceptedValues();

    String message() default "{Not a valid parameter}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
