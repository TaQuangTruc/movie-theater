package __NotFound.movie_theater.Service;

import __NotFound.movie_theater.Dto.Request.Film.FilmCreationDto;
import __NotFound.movie_theater.Dto.Request.Film.FilmUpdateDto;
import __NotFound.movie_theater.Dto.Response.FilmResponse;
import __NotFound.movie_theater.Dto.Response.PageResponse;
import __NotFound.movie_theater.Exception.AppException;
import __NotFound.movie_theater.Exception.ErrorCode;
import __NotFound.movie_theater.Mapper.FilmMapper;
import __NotFound.movie_theater.Repository.FilmRepository;
import lombok.AccessLevel;
import __NotFound.movie_theater.Entity.Film;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FilmService {
    FilmRepository filmRepository;

    FilmMapper filmMapper;

    public FilmResponse createFilm(FilmCreationDto filmCreationDto) {
        if (filmRepository.existsByName(filmCreationDto.getName()))
            throw new AppException(ErrorCode.EXIST_FILM);

        Film film = filmMapper.toFilm(filmCreationDto);

        return filmMapper.toFilmResponse(filmRepository.save(film));
    }

    public FilmResponse findById(String filmId) {
        return filmMapper.toFilmResponse(filmRepository.findById(filmId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXIST_FILM)));
    }

    public List<FilmResponse> findAll() {
        return filmMapper.toListFilmResponse(filmRepository.findAll());
    }

    public PageResponse<FilmResponse> pagination(int page, int size) {
        Sort sort = Sort.by(Sort.Order.asc("releaseDate"), Sort.Order.desc("name"));
        Pageable pageable = PageRequest.of(page - 1, size, sort);

        var pageData = filmRepository.findAll(pageable);

        return PageResponse.<FilmResponse>builder()
                .currentPage(page)
                .pageSize(pageData.getSize())
                .totalPages(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream().map(filmMapper::toFilmResponse).toList())
                .build();
    }

    public FilmResponse updateFilm(String filmId, FilmUpdateDto filmUpdateDto) {
        Film existingFilm = filmRepository.findById(filmId)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_EXIST_FILM));

        // Check duplicate name, excluding the current film
        if (filmUpdateDto.getName() != null
                && filmRepository.existsByNameAndIdNot(filmUpdateDto.getName(), existingFilm.getId())) {
            throw new AppException(ErrorCode.EXIST_FILM);
        }

        // Update the film entity
        filmMapper.updateFilm(existingFilm, filmUpdateDto);

        // Save and map to response
        return filmMapper.toFilmResponse(filmRepository.save(existingFilm));
    }

    public void deleteById(String filmId) {
        if (!filmRepository.existsById(filmId))
            throw new AppException(ErrorCode.NOT_EXIST_FILM);

        filmRepository.deleteById(filmId);
    }
}
