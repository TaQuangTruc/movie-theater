package __NotFound.movie_theater.Controller;

import __NotFound.movie_theater.Dto.Response.ApiResponseDto;
import __NotFound.movie_theater.Dto.Request.User.UserCreationDto;
import __NotFound.movie_theater.Dto.Request.User.UserUpdateDto;
import __NotFound.movie_theater.Dto.Response.UserResponse;
import __NotFound.movie_theater.Service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("")
    ApiResponseDto<UserResponse> createUser(@RequestBody @Valid UserCreationDto userCreationDto) {
        ApiResponseDto<UserResponse> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(userService.createUser(userCreationDto));

        return apiResponseDto;
    }

    @GetMapping("")
    ApiResponseDto<List<UserResponse>> getListUsers() {
        ApiResponseDto<List<UserResponse>> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(userService.getListUsers());

        return apiResponseDto;
    }

    @PutMapping("/{userId}")
    ApiResponseDto<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody @Valid UserUpdateDto userUpdateDto) {
        ApiResponseDto<UserResponse> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(userService.updateUser(userId, userUpdateDto));

        return apiResponseDto;
    }

    @DeleteMapping("/{userId}")
    ApiResponseDto<String> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);

        ApiResponseDto<String> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult("User has been deleted");

        return apiResponseDto;
    }

    @GetMapping("/{userId}")
    ApiResponseDto<UserResponse> getUser(@PathVariable("userId") String userId) {
        ApiResponseDto<UserResponse> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(userService.getUser(userId));

        return apiResponseDto;
    }
}
