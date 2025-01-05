package __NotFound.movie_theater.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = { EmailValidator.class }
)
public @interface EmailConstraint {
    String message() default "INVALID_EMAIL";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String end();
}
