package __NotFound.movie_theater.Dto.Request.Genre;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreCreationDto {
    @NotNull(message = "GENRE_NULL_NAME")
    @NotEmpty(message = "GENRE_EMPTY_NAME")
    String name;

    @NotNull(message = "GENRE_NULL_DESC")
    String description;
}
