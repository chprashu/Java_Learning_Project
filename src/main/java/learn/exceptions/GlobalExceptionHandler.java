package learn.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(HttpServletRequest request, Exception ex){

        StackTraceElement element = ex.getStackTrace()[0];
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                ex.toString(),
                request != null ? request.getRequestURI() : ""
        );
        log.error("Exception occurred!, Type:"+ex.getClass().getName()+", Message:"+ex.getMessage()+", In class: "+element.getClassName()
                + ", In method:"+element.getMethodName()+", In lineNumber:"+element.getLineNumber());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
