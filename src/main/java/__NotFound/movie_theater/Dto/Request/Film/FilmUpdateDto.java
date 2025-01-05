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
public class FilmUpdateDto {
    @Size(min = 1, message = "NOT_EMPTY_NAME")
    String name;

    @Size(min = 1, message = "NOT_EMPTY_DESCRIPTION")
    String description;

    @Min(value = 0, message = "POSITIVE_AGE_LIMIT")
    Integer ageLimit;

    @Size(min = 1, message = "NOT_EMPTY_NATION")
    String nation;

    @Min(value = 0, message = "POSITIVE_DURATION")
    Integer duration;

    @ReleaseDateConstraint(message = "INVALID_RELEASE_DATE")
    LocalDate releaseDate;
}
