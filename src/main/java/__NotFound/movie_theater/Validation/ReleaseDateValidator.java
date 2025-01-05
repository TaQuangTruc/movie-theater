package __NotFound.movie_theater.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Objects;

public class ReleaseDateValidator implements ConstraintValidator<ReleaseDateConstraint, LocalDate> {

    private LocalDate endDate;

    @Override
    public void initialize(ReleaseDateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        endDate = LocalDate.now();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (Objects.isNull(date)) {
            return true;
        }

        return date.isAfter(endDate);
    }
}
