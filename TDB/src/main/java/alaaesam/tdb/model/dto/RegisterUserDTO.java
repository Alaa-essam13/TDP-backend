package alaaesam.tdb.model.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserDTO implements Serializable {
    private String userName;
    private String email;
    private String role;
    private String password;
}

