package __NotFound.movie_theater.Service;

import __NotFound.movie_theater.Dto.Request.Genre.GenreCreationDto;
import __NotFound.movie_theater.Dto.Request.Genre.GenreUpdateDto;
import __NotFound.movie_theater.Dto.Response.GenreResponse;
import __NotFound.movie_theater.Dto.Response.PageResponse;
import __NotFound.movie_theater.Entity.Genre;
import __NotFound.movie_theater.Exception.AppException;
import __NotFound.movie_theater.Exception.ErrorCode;
import __NotFound.movie_theater.Mapper.GenreMapper;
import __NotFound.movie_theater.Repository.GenreRepository;
import lombok.AccessLevel;
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
public class GenreService {
    GenreRepository genreRepository;

    GenreMapper genreMapper;

    public GenreResponse create(GenreCreationDto genreCreationDto) {
        if (genreRepository.existsByName(genreCreationDto.getName()))
            throw new AppException(ErrorCode.GENRE_NAME_EXIST);

        Genre genre = genreMapper.toGenre(genreCreationDto);

        return genreMapper.toGenreResponse(genreRepository.save(genre));
    }

    public GenreResponse findById(String filmId) {
        return genreMapper.toGenreResponse(genreRepository.findById(filmId)
                .orElseThrow(() -> new AppException(ErrorCode.GENRE_NOT_EXISTED)));
    }

    public List<GenreResponse> findAll() {
        return genreMapper.toListGenreResponse(genreRepository.findAll());
    }

    public PageResponse<GenreResponse> pagination(int page, int size) {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        Pageable pageable = PageRequest.of(page - 1, size, sort);

        var pageData = genreRepository.findAll(pageable);

        return PageResponse.<GenreResponse>builder()
                .currentPage(page)
                .pageSize(pageData.getSize())
                .totalPages(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream().map(genreMapper::toGenreResponse).toList())
                .build();
    }

    public GenreResponse update(String filmId, GenreUpdateDto genreUpdateDto) {
        Genre existingGenre = genreRepository.findById(filmId)
                .orElseThrow(() -> new AppException(ErrorCode.GENRE_NOT_EXISTED));

        // Check duplicate name, excluding the current film
        if (genreUpdateDto.getName() != null
                && genreRepository.existsByNameAndIdNot(genreUpdateDto.getName(), existingGenre.getId())) {
            throw new AppException(ErrorCode.EXIST_FILM);
        }

        genreMapper.updateGenre(existingGenre, genreUpdateDto);

        return genreMapper.toGenreResponse(genreRepository.save(existingGenre));
    }

    public void deleteById(String genreId) {
        if (!genreRepository.existsById(genreId))
            throw new AppException(ErrorCode.GENRE_NOT_EXISTED);

        genreRepository.deleteById(genreId);
    }
}
