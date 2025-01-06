package __NotFound.movie_theater.Dto.Request.Film;

import __NotFound.movie_theater.Validation.ReleaseDateConstraint;
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
    @NotNull(message = "FILM_NULL_NAME")
    @NotEmpty(message = "FILM_EMPTY_NAME")
    String name;

    @NotNull(message = "FILM_NULL_DESCRIPTION")
    @NotEmpty(message = "FILM_EMPTY_DESCRIPTION")
    String description;

    @Positive(message = "FILM_POSITIVE_AGE_LIMIT")
    Integer ageLimit;

    @NotNull(message = "FILM_NULL_NATION")
    @NotEmpty(message = "FILM_EMPTY_NATION")
    String nation;

    @NotNull(message = "FILM_NULL_DURATION")
    @Positive(message = "FILM_POSITIVE_DURATION")
    Integer duration;

    @NotNull(message = "FILM_NULL_RELEASE_DATE")
    @ReleaseDateConstraint(message = "FILM_INVALID_RELEASE_DATE")
    LocalDate releaseDate;
}
