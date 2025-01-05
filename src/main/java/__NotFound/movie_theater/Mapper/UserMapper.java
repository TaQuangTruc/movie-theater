package __NotFound.movie_theater.Mapper;

import __NotFound.movie_theater.Dto.Request.User.UserCreationDto;
import __NotFound.movie_theater.Dto.Request.User.UserUpdateDto;
import __NotFound.movie_theater.Dto.Response.UserResponse;
import __NotFound.movie_theater.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationDto userCreationDto);
    void updateUser(@MappingTarget User user, UserUpdateDto userUpdateDto);
    UserResponse toUserResponse(User userEntity);
    List<UserResponse> toListUserResponse(List<User> listUserEntity);
}
