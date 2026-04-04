package alaaesam.tdb.core.controller;

import alaaesam.tdb.api.service.AuthService;
import alaaesam.tdb.model.dto.LoginUserDTO;
import alaaesam.tdb.model.dto.RegisterUserDTO;
import alaaesam.tdb.model.vto.LoginUserVTO;
import alaaesam.tdb.model.vto.RegisterUserVTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserVTO> register(@Valid @RequestBody RegisterUserDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserVTO> login(@Valid @RequestBody LoginUserDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
