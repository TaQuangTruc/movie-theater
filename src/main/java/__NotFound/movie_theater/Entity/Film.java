package __NotFound.movie_theater.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true)
    String name;

    @Lob        // large object -> can be text
    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    @Min(0)
    Integer ageLimit;

    @Column(nullable = false)
    String nation;

    @Column(nullable = false)
    @Min(0)
    Integer duration;

    @Column(nullable = false)
    LocalDate releaseDate;
}
