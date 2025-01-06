package __NotFound.movie_theater.Dto.Request.User;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateDto {
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate dob;
}
