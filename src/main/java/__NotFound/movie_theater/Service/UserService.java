package __NotFound.movie_theater.Service;

import __NotFound.movie_theater.Dto.Request.User.UserCreationDto;
import __NotFound.movie_theater.Dto.Request.User.UserUpdateDto;
import __NotFound.movie_theater.Dto.Response.UserResponse;
import __NotFound.movie_theater.Entity.User;
import __NotFound.movie_theater.Exception.AppException;
import __NotFound.movie_theater.Exception.ErrorCode;
import __NotFound.movie_theater.Mapper.UserMapper;
import __NotFound.movie_theater.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.out;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;

    UserMapper userMapper;

    public UserResponse createUser(UserCreationDto userCreationDto) {
        if (userRepository.existsByUsername(userCreationDto.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(userCreationDto);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(userCreationDto.getPassword()));

        System.out.println(user);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getListUsers() {
        return userMapper.toListUserResponse(userRepository.findAll());
    }

    public UserResponse getUser(String userId) {
        return userMapper.toUserResponse(userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId))
            throw new AppException(ErrorCode.USER_NOT_EXISTED);

        userRepository.deleteById(userId);
    }

    public UserResponse updateUser(String userId, UserUpdateDto userUpdateDto) {
        if (!userRepository.existsById(userId))
            throw new AppException(ErrorCode.USER_NOT_EXISTED);

        if (userRepository.existsByUsername(userUpdateDto.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
