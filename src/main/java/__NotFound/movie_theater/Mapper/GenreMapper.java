package __NotFound.movie_theater.Mapper;


import __NotFound.movie_theater.Dto.Request.Genre.GenreCreationDto;
import __NotFound.movie_theater.Dto.Request.Genre.GenreUpdateDto;
import __NotFound.movie_theater.Dto.Response.GenreResponse;
import __NotFound.movie_theater.Entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GenreMapper {
    Genre toGenre(GenreCreationDto genreCreationDto);
    void updateGenre(@MappingTarget Genre film, GenreUpdateDto genreUpdateDto);
    GenreResponse toGenreResponse(Genre genre);
    List<GenreResponse> toListGenreResponse(List<Genre> genres);
}
