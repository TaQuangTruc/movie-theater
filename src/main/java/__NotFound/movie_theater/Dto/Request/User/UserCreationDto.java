package __NotFound.movie_theater.Dto.Request.User;

import __NotFound.movie_theater.Validation.EmailConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationDto {
    @NotNull(message = "INVALID_NAME")
    @NotEmpty(message = "INVALID_NAME")
    @Size(min = 8, message = "INVALID_NAME")
    String name;


    @NotNull(message = "INVALID_EMAIL")
    @NotEmpty(message = "INVALID_EMAIL")
    @EmailConstraint(end = "@hcmut.edu.vn", message = "INVALID_EMAIL")
    String email;

    @NotNull(message = "INVALID_PHONE_NUMBER")
    @NotEmpty(message = "INVALID_PHONE_NUMBER")
    String phoneNumber;

    @NotNull(message = "INVALID_USERNAME")
    @NotEmpty(message = "INVALID_USERNAME")
    String username;

    @NotNull(message = "INVALID_PASSWORD")
    @NotEmpty(message = "INVALID_PASSWORD")
    String password;
}
