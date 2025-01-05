package __NotFound.movie_theater.Dto.Request.Genre;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreUpdateDto {
    @Size(min = 1, message = "GENRE_EMPTY_NAME")
    String name;

    String description;
}
