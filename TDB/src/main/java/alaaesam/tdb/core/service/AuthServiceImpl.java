package alaaesam.tdb.core.service;

import alaaesam.tdb.api.repository.UserRepository;
import alaaesam.tdb.api.service.AuthService;
import alaaesam.tdb.core.mapper.GeneralMapper;
import alaaesam.tdb.lib.error.AppException;
import alaaesam.tdb.model.dto.LoginUserDTO;
import alaaesam.tdb.model.dto.RegisterUserDTO;
import alaaesam.tdb.model.entity.User;
import alaaesam.tdb.model.vto.LoginUserVTO;
import alaaesam.tdb.model.vto.RegisterUserVTO;
import alaaesam.tdb.security.service.JWTService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static alaaesam.tdb.lib.error.Error.*;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final GeneralMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginUserVTO login(LoginUserDTO loginUserDTO) {
        User user = userRepository.selectByUserName(loginUserDTO.getUserName()).orElseThrow(() -> new AppException(USER_NOT_FOUND));
        boolean isPasswordMatches = passwordEncoder.matches(loginUserDTO.getPassword(), user.getPassword());
        if (!isPasswordMatches) {
            throw new AppException(USER_NOT_FOUND);
        }
        Map<String, Object> claims = new HashMap<>();
        String token = jwtService.generateToken(loginUserDTO.getUserName(), claims);
        return LoginUserVTO.builder().token(token).build();
    }

    @Override
    public RegisterUserVTO register(RegisterUserDTO registerUserDTO) {
        if (registerUserDTO.getUserName().isBlank()
                || registerUserDTO.getPassword().isBlank()) {
            throw new AppException(INVALID_CREDENTIAL);
        }

        if(userRepository.isEmailExists(registerUserDTO.getEmail()) || userRepository.isUsernameExists(registerUserDTO.getUserName()))
            throw new AppException(USER_ALREADY_EXIST);


        User usr = mapper.toUser(registerUserDTO);

        usr.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        User user=userRepository.insert(usr);
        Map<String, Object> claims = new HashMap<>();
        String token = jwtService.generateToken(user.getUserName(), claims);
        return RegisterUserVTO.builder().token(token).build();
    }
}

