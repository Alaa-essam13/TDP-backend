package alaaesam.tdb.model.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterUserDTO implements Serializable {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
}

