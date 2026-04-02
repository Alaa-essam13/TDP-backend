package alaaesam.tdb.lib.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("errorCode", ex.getErrorCode().name());
        body.put("message", ex.getErrorCode().getMessage());
        body.put("status", ex.getErrorCode().getStatus().value());
        body.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(ex.getErrorCode().getStatus()).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnexpected(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("errorCode", Error.INTERNAL_ERROR.name());
        body.put("message", ex.getMessage());
        body.put("status", 500);
        body.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(500).body(body);
    }
}
