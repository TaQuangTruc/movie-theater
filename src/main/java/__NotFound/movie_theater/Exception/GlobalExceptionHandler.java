package __NotFound.movie_theater.Exception;

import __NotFound.movie_theater.Dto.Response.ApiResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Xử lý các lỗi khác
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponseDto> handlingException(RuntimeException exception){
        ApiResponseDto apiResponseDto = new ApiResponseDto();

        System.out.println(exception);

        apiResponseDto.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponseDto.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity
                .internalServerError()
                .body(apiResponseDto);
    }

    // Xử lý lỗi do giá trị đầu vào không đúng
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponseDto> handlingNotValidException(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;

        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid enum key: {}");
        }

        ApiResponseDto apiResponseDto = new ApiResponseDto();

        apiResponseDto.setCode(errorCode.getCode());
        apiResponseDto.setMessage(errorCode.getMessage());

        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(apiResponseDto);
    }

    // Xử lý các ràng buộc tự mặc định
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponseDto> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponseDto apiResponseDto = new ApiResponseDto();

        apiResponseDto.setCode(errorCode.getCode());
        apiResponseDto.setMessage(errorCode.getMessage());

        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(apiResponseDto);
    }
}
