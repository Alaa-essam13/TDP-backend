package alaaesam.tdb.repository.jpa;

import alaaesam.tdb.model.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface UserJPARepository extends JpaRepositoryImplementation<User,Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);
}
