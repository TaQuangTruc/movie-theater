package __NotFound.movie_theater.Repository;

import __NotFound.movie_theater.Entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(@NonNull String username);
    boolean existsById(@NonNull String id);
    Optional<User> findByPhoneNumber(@NonNull String phoneNumber);
}
