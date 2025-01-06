package __NotFound.movie_theater.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String name;
    String email;
    String phoneNumber;
    String username;
    String password;
    LocalDate dob;
}
