package alaaesam.tdb.model.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUserDTO implements Serializable {
    private String userName;
    private String password;
}

