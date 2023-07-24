package com.example.gestion.des.voyages.handlers;

import com.example.gestion.des.voyages.execption.EntityNotfoundException;
import com.example.gestion.des.voyages.execption.ErrorCodes;
import com.example.gestion.des.voyages.execption.InvalidEntityException;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InvalidClassException;

@Builder
@RestControllerAdvice
public class Restexceptionhandlers {
   @ExceptionHandler(EntityNotfoundException.class)
    public ResponseEntity<errorDto> handleException(EntityNotfoundException exception, WebRequest webRequest)
    {
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final errorDto errorDto1 = errorDto.builder()
            .code(exception.getErrorCode())
            .httpCode(notFound.value())
            .message(exception.getMessage())
        .build();
        return new ResponseEntity<>(errorDto1, notFound);

    }
    @ExceptionHandler(InvalidClassException.class)
    public ResponseEntity<errorDto> handleException(InvalidEntityException exception, WebRequest webRequest)
    {
        final HttpStatus badrequest = HttpStatus.BAD_REQUEST;
        final errorDto errorDto1 = errorDto.builder()
            .code(exception.getErrorCode())
            .httpCode(badrequest.value())
            .message(exception.getMessage())
            .errors((exception.getErrors()))
            .build();
        return new ResponseEntity<>(errorDto1, badrequest);

    }

}
