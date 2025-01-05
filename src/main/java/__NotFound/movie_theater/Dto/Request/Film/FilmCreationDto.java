package __NotFound.movie_theater.Dto.Request.Film;

import __NotFound.movie_theater.Validation.EmailConstraint;
import __NotFound.movie_theater.Validation.ReleaseDateConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmCreationDto {
    @NotNull(message = "NOT_NULL_NAME")
    @NotEmpty(message = "NOT_EMPTY_NAME")
    String name;

    @NotNull(message = "NOT_NULL_DESCRIPTION")
    @NotEmpty(message = "NOT_EMPTY_DESCRIPTION")
    String description;

    @Positive(message = "POSITIVE_AGE_LIMIT")
    Integer ageLimit;

    @NotNull(message = "NOT_NULL_NATION")
    @NotEmpty(message = "NOT_EMPTY_NATION")
    String nation;

    @NotNull(message = "NOT_NULL_DURATION")
    @Positive(message = "POSITIVE_DURATION")
    Integer duration;

    @NotNull(message = "NOT_NULL_RELEASE_DATE")
    @ReleaseDateConstraint(message = "INVALID_RELEASE_DATE")
    LocalDate releaseDate;
}
