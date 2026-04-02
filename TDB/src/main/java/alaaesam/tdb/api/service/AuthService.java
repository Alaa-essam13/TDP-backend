package alaaesam.tdb.api.service;

import alaaesam.tdb.model.dto.LoginUserDTO;
import alaaesam.tdb.model.dto.RegisterUserDTO;
import alaaesam.tdb.model.vto.LoginUserVTO;
import alaaesam.tdb.model.vto.RegisterUserVTO;

public interface AuthService {

    LoginUserVTO login(LoginUserDTO loginUserDTO);
    RegisterUserVTO register(RegisterUserDTO registerUserDTO);
}
