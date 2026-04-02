package alaaesam.tdb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginUserDTO implements Serializable {
    private String userName;
    private String password;
}

