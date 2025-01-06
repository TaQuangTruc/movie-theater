package __NotFound.movie_theater.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(1000, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),

    USER_EXISTED(2000, "Username exists", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(2001, "User not exists", HttpStatus.NOT_FOUND),
    USER_LENGTH_USERNAME(2002, "Username must be at least 8 characters", HttpStatus.BAD_REQUEST),
    USER_NULL_USERNAME(2003, "Username must not be null", HttpStatus.BAD_REQUEST),
    USER_LENGTH_PASSWORD(2004, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    USER_NULL_PASSWORD(2005, "Password must not be null", HttpStatus.BAD_REQUEST),
    USER_NULL_FIRSTNAME(2006, "Firstname must not be null", HttpStatus.BAD_REQUEST),
    USER_EMPTY_FIRSTNAME(2007, "Firstname must not be empty", HttpStatus.BAD_REQUEST),
    USER_NULL_LASTNAME(2008, "Lastname must not be null", HttpStatus.BAD_REQUEST),
    USER_EMPTY_LASTNAME(2009, "Lastname must not be empty", HttpStatus.BAD_REQUEST),
    USER_NULL_EMAIL(2010, "Email must not be null", HttpStatus.BAD_REQUEST),
    USER_INVALID_EMAIL(2011, "Email is invalid", HttpStatus.BAD_REQUEST),
    USER_NULL_PHONENUMBER(2012, "Phone number must not be null", HttpStatus.BAD_REQUEST),
    USER_INVALID_PHONENUMBER(2013, "Phone number must consist of 10 digits and start with 0", HttpStatus.BAD_REQUEST),
    USER_NULL_DOB(2014, "Day of birth must not be null", HttpStatus.BAD_REQUEST),
    USER_MIN_DOB(2015, "You must be at least 18 years old to register", HttpStatus.BAD_REQUEST),

    FILM_NULL_NAME(3000, "Movie name must not be null", HttpStatus.BAD_REQUEST),
    FILM_EMPTY_NAME(3001, "Movie name must not be empty", HttpStatus.BAD_REQUEST),
    FILM_NULL_DESCRIPTION(3002, "Description must not be null", HttpStatus.BAD_REQUEST),
    FILM_EMPTY_DESCRIPTION(3003, "Description must not be empty", HttpStatus.BAD_REQUEST),
    FILM_POSITIVE_AGE_LIMIT(3004, "Age limit must be a positive number", HttpStatus.BAD_REQUEST),
    FILM_NULL_NATION(3005, "Nation must not be null", HttpStatus.BAD_REQUEST),
    FILM_EMPTY_NATION(3006, "Nation must not be empty", HttpStatus.BAD_REQUEST),
    FILM_NULL_DURATION(3007, "Duration must not be null", HttpStatus.BAD_REQUEST),
    FILM_POSITIVE_DURATION(3008, "Duration must be a positive number", HttpStatus.BAD_REQUEST),
    FILM_NULL_RELEASE_DATE(3009, "Release date must not be null", HttpStatus.BAD_REQUEST),
    FILM_INVALID_RELEASE_DATE(3010, "Release date must be after today", HttpStatus.BAD_REQUEST),
    FILM_EXIST_NAME(3011, "Name must be exist", HttpStatus.BAD_REQUEST),
    FILM_NOT_EXISTED(3012, "Film not exist", HttpStatus.BAD_REQUEST);

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
