package __NotFound.movie_theater.Controller;

import __NotFound.movie_theater.Dto.Request.Film.FilmCreationDto;
import __NotFound.movie_theater.Dto.Request.Film.FilmUpdateDto;
import __NotFound.movie_theater.Dto.Request.User.UserCreationDto;
import __NotFound.movie_theater.Dto.Request.User.UserUpdateDto;
import __NotFound.movie_theater.Dto.Response.ApiResponseDto;
import __NotFound.movie_theater.Dto.Response.FilmResponse;
import __NotFound.movie_theater.Dto.Response.UserResponse;
import __NotFound.movie_theater.Service.FilmService;
import __NotFound.movie_theater.Service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("films")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FilmController {
    FilmService filmService;

    @PostMapping("")
    ApiResponseDto<FilmResponse> createUser(@RequestBody @Valid FilmCreationDto filmCreationDto) {
        ApiResponseDto<FilmResponse> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(filmService.createFilm(filmCreationDto));

        return apiResponseDto;
    }

    @GetMapping("")
    ApiResponseDto<List<FilmResponse>> findAll() {
        ApiResponseDto<List<FilmResponse>> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(filmService.findAll());

        return apiResponseDto;
    }

    @GetMapping("{filmId}")
    ApiResponseDto<FilmResponse> findById(@PathVariable("filmId") String filmId) {
        ApiResponseDto<FilmResponse> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(filmService.findById(filmId));

        return apiResponseDto;
    }

    @PutMapping("/{filmId}")
    ApiResponseDto<FilmResponse> updateFilm(@PathVariable("filmId") String filmId, @RequestBody @Valid FilmUpdateDto filmUpdateDto) {
        ApiResponseDto<FilmResponse> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult(filmService.updateFilm(filmId, filmUpdateDto));

        return apiResponseDto;
    }

    @DeleteMapping("/{filmId}")
    ApiResponseDto<String> deleteUser(@PathVariable("filmId") String filmId) {
        filmService.deleteById(filmId);

        ApiResponseDto<String> apiResponseDto = new ApiResponseDto<>();

        apiResponseDto.setResult("Film has been deleted");

        return apiResponseDto;
    }

}
