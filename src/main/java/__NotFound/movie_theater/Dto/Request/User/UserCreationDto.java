package __NotFound.movie_theater.Dto.Request.User;

import __NotFound.movie_theater.Validation.DobConstraint;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationDto {
    @NotNull(message = "INVALID_USERNAME")
    @Size(min = 8, message = "USER_LENGTH_USERNAME")
    String username;

    @NotNull(message = "USER_NULL_PASSWORD")
    @Size(min = 8, message = "USER_LENGTH_PASSWORD")
    String password;

    @NotNull(message = "USER_NULL_FIRSTNAME")
    @NotEmpty(message = "USER_EMPTY_FIRSTNAME")
    String firstName;

    @NotNull(message = "USER_NULL_LASTNAME")
    @NotEmpty(message = "USER_EMPTY_LASTNAME")
    String lastName;

    @NotNull(message = "USER_NULL_EMAIL")
    @Email(message = "USER_INVALID_EMAIL")
    String email;

    @NotNull(message = "USER_NULL_PHONENUMBER")
    @Pattern(regexp = "0\\d{9}", message = "USER_INVALID_PHONENUMBER")
    String phoneNumber;

    @NotNull(message = "USER_NULL_DOB")
    @DobConstraint(min = 18, message = "USER_MIN_DOB")
    LocalDate dob;
}
