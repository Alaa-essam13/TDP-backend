package alaaesam.tdb.api.repository;

import alaaesam.tdb.model.entity.User;

import java.util.Optional;

public interface UserRepository {
    User insert(User user);

    User update(User user);

    Optional<User> selectById(Long userId);

    Optional<User> selectByUserName(String userName);
    Optional<User> selectByEmail(String email);

    Boolean isEmailExists(String email);
    Boolean isUsernameExists(String username);
}

