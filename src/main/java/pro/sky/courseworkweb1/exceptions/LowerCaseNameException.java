package pro.sky.courseworkweb1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class LowerCaseNameException extends RuntimeException{
    public LowerCaseNameException() {
    }

    public LowerCaseNameException(String message) {
        super(message);
    }

    public LowerCaseNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public LowerCaseNameException(Throwable cause) {
        super(cause);
    }

    public LowerCaseNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
