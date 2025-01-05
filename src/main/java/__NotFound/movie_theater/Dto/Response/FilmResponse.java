package __NotFound.movie_theater.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmResponse {
    String id;
    String name;
    String description;
    Integer ageLimit;
    String nation;
    Integer duration;
    LocalDate releaseDate;
}
