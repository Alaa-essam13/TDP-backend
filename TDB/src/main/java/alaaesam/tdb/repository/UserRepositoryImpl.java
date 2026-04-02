package alaaesam.tdb.repository;

import alaaesam.tdb.api.repository.UserRepository;
import alaaesam.tdb.model.entity.User;
import alaaesam.tdb.repository.jpa.UserJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;
    @Override
    public User insert(User user) {
        return userJPARepository.save(user);
    }

    @Override
    public User update(User user) {
        return userJPARepository.save(user);
    }

    @Override
    public Optional<User> selectById(Long userId) {
        return userJPARepository.findById(userId);
    }

    @Override
    public Optional<User> selectByUserName(String userName) {
        return userJPARepository.findByUserName(userName);
    }

    @Override
    public Optional<User> selectByEmail(String email) {
        return userJPARepository.findByEmail(email);
    }

    @Override
    public Boolean isEmailExists(String email) {
        return userJPARepository.existsByEmail(email);
    }

    @Override
    public Boolean isUsernameExists(String username) {
        return userJPARepository.existsByUserName(username);
    }
}
