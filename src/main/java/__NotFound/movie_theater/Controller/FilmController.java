package __NotFound.movie_theater.Controller;

import __NotFound.movie_theater.Dto.Request.Film.FilmCreationDto;
import __NotFound.movie_theater.Dto.Request.Film.FilmUpdateDto;
import __NotFound.movie_theater.Dto.Response.ApiResponseDto;
import __NotFound.movie_theater.Dto.Response.FilmResponse;
import __NotFound.movie_theater.Dto.Response.PageResponse;
import __NotFound.movie_theater.Service.FilmService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("films")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FilmController {
    FilmService filmService;

    @PostMapping("")
    ApiResponseDto<FilmResponse> createFilm(@RequestBody @Valid FilmCreationDto filmCreationDto) {
        return ApiResponseDto.<FilmResponse>builder()
                .result(filmService.createFilm(filmCreationDto))
                .build();
    }


    @Transactional(readOnly = true)
    @GetMapping("")
    ApiResponseDto<PageResponse<FilmResponse>> pagination(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        return ApiResponseDto.<PageResponse<FilmResponse>>builder()
                .result(filmService.pagination(page, size))
                .build();
    }

    @Transactional(readOnly = true)
    @GetMapping("{filmId}")
    ApiResponseDto<FilmResponse> findById(@PathVariable("filmId") String filmId) {
        return ApiResponseDto.<FilmResponse>builder()
                .result(filmService.findById(filmId))
                .build();
    }

    @PutMapping("/{filmId}")
    ApiResponseDto<FilmResponse> updateFilm(@PathVariable("filmId") String filmId, @RequestBody @Valid FilmUpdateDto filmUpdateDto) {
        return ApiResponseDto.<FilmResponse>builder()
                .result(filmService.updateFilm(filmId, filmUpdateDto))
                .build();
    }

    @DeleteMapping("/{filmId}")
    ApiResponseDto<String> deleteUser(@PathVariable("filmId") String filmId) {
        filmService.deleteById(filmId);

        return ApiResponseDto.<String>builder()
                .result("Film has been deleted")
                .build();
    }
}
