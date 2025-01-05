package __NotFound.movie_theater.Repository;

import __NotFound.movie_theater.Entity.Genre;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
    boolean existsById(@NonNull String id);
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(@NonNull String name, String filmId);
    Page<Genre> findAll(Pageable pageable);
}
