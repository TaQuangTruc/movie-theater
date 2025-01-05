package __NotFound.movie_theater.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User exists", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1003, "User not exists", HttpStatus.NOT_FOUND),
    INVALID_NAME(1004, "Name must be at least 8 characters", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1005, "Email must be end by {end}", HttpStatus.BAD_REQUEST),
    INVALID_PHONE_NUMBER(1006, "Phone number is invalid", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME(1007, "Username is invalid", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1008, "Password is invalid", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(2000, "Unauthenticated", HttpStatus.UNAUTHORIZED);

    private int code;
    private String message;
    private HttpStatusCode statusCode;

    // Constructor
    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
