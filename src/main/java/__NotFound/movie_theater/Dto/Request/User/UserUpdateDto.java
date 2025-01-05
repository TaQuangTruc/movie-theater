package __NotFound.movie_theater.Dto.Request.User;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateDto {
    String name;
    String email;
    String phoneNumber;
    String username;
    String password;
}
