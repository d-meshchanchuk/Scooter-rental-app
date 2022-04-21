package com.senla.scooterrentalapp.exeption.handling;

import com.senla.scooterrentalapp.dto.ErrorDTO;
import com.senla.scooterrentalapp.exeption.NoContentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorDTO handleValidationException(ConstraintViolationException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .status(BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ErrorDTO handleNotFoundException(NoContentException e) {
        log.error(e.getMessage(), e);
        return ErrorDTO.builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
