package pl.piasta.hotel.api.rooms.utils;

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
@Target({
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER
})
public @interface ValidateString {

    String[] acceptedValues();

    String message() default "{Not a valid parameter}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
