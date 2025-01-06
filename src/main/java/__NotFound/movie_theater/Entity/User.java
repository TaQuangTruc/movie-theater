package __NotFound.movie_theater.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String fisrtName;

    @Column(nullable = false)
    String lastName;

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true, nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    LocalDate dob;
}
