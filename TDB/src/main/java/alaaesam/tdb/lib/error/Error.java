package alaaesam.tdb.lib.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    USER_NOT_FOUND("Wrong Email Or Password", HttpStatus.NOT_FOUND),
    INVALID_CREDENTIAL("Invalid Email Or Password", HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXIST("User Already Exist", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST("Invalid request data", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("You are not authorized", HttpStatus.UNAUTHORIZED),
    INTERNAL_ERROR("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR),
    ROLE_NOT_FOUND("role not found", HttpStatus.NOT_FOUND),
    ;
    private final String message;
    private final HttpStatus status;

    Error(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
