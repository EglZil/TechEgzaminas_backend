package lt.tehcin.myProject.api;

import lt.tehcin.myProject.api.dto.ErrorDto;
import lt.tehcin.myProject.api.dto.ErrorFieldDto;
import lt.tehcin.myProject.exception.RecordValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(RecordValidationException.class)
    public ResponseEntity<ErrorDto> handleZooValidationException(HttpServletRequest request, RecordValidationException recordValidationException) {
        logger.error("zooValidationException: {}, for field: {}", recordValidationException.getMessage(), recordValidationException.getField());

        var errorStatus = HttpStatus.BAD_REQUEST;

        var errorFields = List.of(
                new ErrorFieldDto(recordValidationException.getField(), recordValidationException.getError(), recordValidationException.getRejectedValue())
        );

        var errorDto = new ErrorDto(request.getRequestURL().toString(),
                errorFields,
                recordValidationException.getMessage(),
                errorStatus.value(),
                errorStatus.getReasonPhrase(),
                request.getRequestURL().toString(),
                LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleZooValidationException(ConstraintViolationException exception) {
        logger.error("zooValidationException: {}, for field: {}", exception.getMessage(), exception.getCause());

        var errorStatus = HttpStatus.BAD_REQUEST;

        var errorDto = new ErrorDto(
                errorStatus.value(),
                exception.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }

}
