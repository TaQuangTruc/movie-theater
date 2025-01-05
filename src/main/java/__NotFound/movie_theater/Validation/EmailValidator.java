package __NotFound.movie_theater.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    private String end;

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        end = constraintAnnotation.end();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(s))
            return true;

        return s.endsWith(end);
    }
}
