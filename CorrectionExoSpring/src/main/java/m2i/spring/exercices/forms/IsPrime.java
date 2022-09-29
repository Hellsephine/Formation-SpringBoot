package m2i.spring.exercices.forms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PrimerValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsPrime {

    String message() default "Not a primer number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
