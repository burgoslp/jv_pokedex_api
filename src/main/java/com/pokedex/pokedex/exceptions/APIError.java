package com.pokedex.pokedex.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;


public enum APIError {
    POKEMON_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El ID ingresado no pertenece a ningun pokemon existente",List.of("")),
    POKEMON_VALUE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El valor ingresado no pertenece a algun pokemon",List.of("")),
    POKEMON_VALIDATION_ERROR(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Algunos de los valores ingresados no son correctos",List.of("")),
    EVOLUTION_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El ID ingresado no pertenece a ninguna evolución existente",List.of("")),
    EVOLUTION_VALUE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El valor ingresado no pertenece a alguna evolución",List.of(""));

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
    private final List<String> data;

    APIError(Integer code, HttpStatus httpStatus, String message,List<String>  data){
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getData() {
        return data;
    }
    
}
