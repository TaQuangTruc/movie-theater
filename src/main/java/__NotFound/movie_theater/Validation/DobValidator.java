package __NotFound.movie_theater.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class DobValidator implements ConstraintValidator<DobConstraint, LocalDate> {

    private int min;

    @Override
    public void initialize(DobConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(dob)) {
            return true;
        }

        int age = Period.between(dob, LocalDate.now()).getYears();

        return age >= min;
    }
}
