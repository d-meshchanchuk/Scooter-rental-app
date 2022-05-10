package com.senla.scooterrentalapp.exception.handling;

import com.senla.scooterrentalapp.dto.ErrorDTO;
import com.senla.scooterrentalapp.exception.NoContentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

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

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ErrorDTO handleAuthenticationException(AuthenticationException e) {
        return ErrorDTO.builder()
                .message(e.getMessage())
                .status(UNAUTHORIZED)
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
