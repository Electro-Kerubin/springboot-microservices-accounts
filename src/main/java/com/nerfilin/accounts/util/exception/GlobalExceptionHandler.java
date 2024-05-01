package com.nerfilin.accounts.util.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.nerfilin.accounts.dto.ErrorResponseDto;

public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception,
                                                                                WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false),
            HttpStatus.BAD_REQUEST,
            exception.getMessage(),
            LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}