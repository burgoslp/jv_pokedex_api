package com.pokedex.pokedex.exceptions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<JsonApiresponse> handleApiException(APIException ex){

        return ResponseEntity.status(ex.getHttpStatus()).body(JsonApiresponse.builder().code(ex.getCode()).message(ex.getHttpStatus().getReasonPhrase()).data(ex.getMessage()).build());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonApiresponse> notValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getFieldErrors().forEach(err -> errors.add(err.getField() +": "+err.getDefaultMessage()));
        
        return ResponseEntity.badRequest().body(JsonApiresponse.builder().code(APIError.POKEMON_VALIDATION_ERROR.getCode()).message(APIError.POKEMON_VALIDATION_ERROR.getHttpStatus().getReasonPhrase()).data(errors).build());
    }

}
