package alaaesam.tdb.security.service;

import alaaesam.tdb.api.repository.UserRepository;
import alaaesam.tdb.lib.CommonData;
import alaaesam.tdb.lib.error.AppException;
import alaaesam.tdb.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static alaaesam.tdb.lib.error.Error.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserDetailsSecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    private final CommonData commonData;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.selectByUserName(username).orElseThrow(()->new AppException(USER_NOT_FOUND));
        commonData.setUserId(user.getId());

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public String getPassword() {
                return user.getUserName();
            }

            @Override
            public String getUsername() {
                return user.getPassword();
            }
        };
    }
}
