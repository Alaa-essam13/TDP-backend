package alaaesam.tdb.lib.error;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    private final Error errorCode;

    public AppException(Error errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public Error getErrorCode() {
        return errorCode;
    }
}
