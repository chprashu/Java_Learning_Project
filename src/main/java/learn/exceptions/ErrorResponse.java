package learn.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class ErrorResponse{

    private final Date timeStamp = new Date();
    private String message;
    private String details;
    private String path;

    public ErrorResponse(String details, String message) {
        this.message = message;
        this.details = details;
    }

    public ErrorResponse(String message, String details, String path) {
        this.message = message;
        this.details = details;
        this.path = path;
    }
}
