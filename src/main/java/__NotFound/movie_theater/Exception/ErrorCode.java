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
    UNAUTHENTICATED(2000, "Unauthenticated", HttpStatus.UNAUTHORIZED),

    NOT_NULL_NAME(3000, "Movie name must not be null", HttpStatus.BAD_REQUEST),
    NOT_EMPTY_NAME(3001, "Movie name must not be empty", HttpStatus.BAD_REQUEST),
    NOT_NULL_DESCRIPTION(3002, "Description must not be null", HttpStatus.BAD_REQUEST),
    NOT_EMPTY_DESCRIPTION(3003, "Description must not be empty", HttpStatus.BAD_REQUEST),
    POSITIVE_AGE_LIMIT(3004, "Age limit must be a positive number", HttpStatus.BAD_REQUEST),
    NOT_NULL_NATION(3005, "Nation must not be null", HttpStatus.BAD_REQUEST),
    NOT_EMPTY_NATION(3006, "Nation must not be empty", HttpStatus.BAD_REQUEST),
    NOT_NULL_DURATION(3007, "Duration must not be null", HttpStatus.BAD_REQUEST),
    POSITIVE_DURATION(3008, "Duration must be a positive number", HttpStatus.BAD_REQUEST),
    NOT_NULL_RELEASE_DATE(3009, "Release date must not be null", HttpStatus.BAD_REQUEST),
    INVALID_RELEASE_DATE(3010, "Release date must be after today", HttpStatus.BAD_REQUEST),
    EXIST_FILM(3011, "Name must be exist", HttpStatus.BAD_REQUEST),
    NOT_EXIST_FILM(3012, "Film not exist", HttpStatus.BAD_REQUEST),

    GENRE_NAME_EXIST(4000, "Name must exist", HttpStatus.BAD_REQUEST),
    GENRE_NOT_EXISTED(4001, "Genre not exist", HttpStatus.BAD_REQUEST),
    GENRE_EMPTY_NAME(4002, "Name must not be empty", HttpStatus.BAD_REQUEST),
    GENRE_NULL_NAME(4003, "Name must not be null", HttpStatus.BAD_REQUEST),
    GENRE_NULL_DESC(4003, "Name must not be null", HttpStatus.BAD_REQUEST),
    ;

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
