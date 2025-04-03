package com.pokedex.pokedex.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import dtos.json.JsonApiresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<JsonApiresponse> handleApiException(APIException ex){
        JsonApiresponse jsonApiresponse= new JsonApiresponse();       

        jsonApiresponse.setCode(ex.getCode());
        jsonApiresponse.setMessage(ex.getHttpStatus().getReasonPhrase());
        jsonApiresponse.setData(List.of(ex.getMessage()));

        return ResponseEntity.status(ex.getHttpStatus()).body(jsonApiresponse);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonApiresponse> notValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        JsonApiresponse jsonApiresponse= new JsonApiresponse(); 

        ex.getFieldErrors().forEach(err -> errors.add(err.getField() +": "+err.getDefaultMessage()));

        jsonApiresponse.setCode(APIError.POKEMON_VALIDATION_ERROR.getCode());
        jsonApiresponse.setMessage(APIError.POKEMON_VALIDATION_ERROR.getHttpStatus().getReasonPhrase());
        jsonApiresponse.setData(errors);


        return ResponseEntity.badRequest().body(jsonApiresponse);
    }

}
