package __NotFound.movie_theater.Controller;

import __NotFound.movie_theater.Dto.Request.Genre.GenreCreationDto;
import __NotFound.movie_theater.Dto.Request.Genre.GenreUpdateDto;
import __NotFound.movie_theater.Dto.Response.ApiResponseDto;
import __NotFound.movie_theater.Dto.Response.GenreResponse;
import __NotFound.movie_theater.Dto.Response.PageResponse;
import __NotFound.movie_theater.Service.GenreService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("genres")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GenreController {
    GenreService genreService;

    @PostMapping("")
    ApiResponseDto<GenreResponse> create(@RequestBody @Valid GenreCreationDto genreCreationDto) {
        return ApiResponseDto.<GenreResponse>builder()
                .result(genreService.create(genreCreationDto))
                .build();
    }


    @Transactional(readOnly = true)
    @GetMapping("")
    ApiResponseDto<PageResponse<GenreResponse>> pagination(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        return ApiResponseDto.<PageResponse<GenreResponse>>builder()
                .result(genreService.pagination(page, size))
                .build();
    }

    @Transactional(readOnly = true)
    @GetMapping("{genreId}")
    ApiResponseDto<GenreResponse> findById(@PathVariable("genreId") String genreId) {
        return ApiResponseDto.<GenreResponse>builder()
                .result(genreService.findById(genreId))
                .build();
    }

    @PutMapping("/{genreId}")
    ApiResponseDto<GenreResponse> updateFilm(@PathVariable("genreId") String genreId, @RequestBody @Valid GenreUpdateDto genreUpdateDto) {
        return ApiResponseDto.<GenreResponse>builder()
                .result(genreService.update(genreId, genreUpdateDto))
                .build();
    }

    @DeleteMapping("/{genreId}")
    ApiResponseDto<String> delete(@PathVariable("genreId") String genreId) {
        genreService.deleteById(genreId);

        return ApiResponseDto.<String>builder()
                .result("Film has been deleted")
                .build();
    }
}
