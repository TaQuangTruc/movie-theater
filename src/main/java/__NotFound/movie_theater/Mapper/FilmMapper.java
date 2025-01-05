package __NotFound.movie_theater.Mapper;

import __NotFound.movie_theater.Dto.Request.Film.FilmCreationDto;
import __NotFound.movie_theater.Dto.Request.Film.FilmUpdateDto;
import __NotFound.movie_theater.Dto.Response.FilmResponse;
import __NotFound.movie_theater.Entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FilmMapper {
    Film toFilm(FilmCreationDto filmCreationDto);
    void updateFilm(@MappingTarget Film film, FilmUpdateDto filmUpdateDto);
    FilmResponse toFilmResponse(Film film);
    List<FilmResponse> toListFilmResponse(List<Film> listFilm);
}
