package com.pokedex.pokedex.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;


public enum APIError {
    POKEMON_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El ID ingresado no pertenece a ningun pokemon existente",List.of("")),
    POKEMON_VALUE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"No se han encontrado resultados en los pokémons",List.of("")),
    POKEMON_VALIDATION_ERROR(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Algunos de los valores ingresados no son correctos",List.of("")),
    EVOLUTION_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El ID ingresado no pertenece a ninguna evolución existente",List.of("")),
    EVOLUTION_VALUE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"No se han encontrado resultados en las evoluciones",List.of("")),
    TYPE_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"El ID ingresado no pertenece a ningun tipo",List.of("")),
    TYPELIST_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Uno de los ID ingresado no pertenece a ningun tipo",List.of("")),
    TYPElIST_BYID_COINCIDENCE(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Uno de los ID ingresado ya esta agregado en los tipos.",List.of("")),
    WEAKNESSlIST_BYID_COINCIDENCE(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Uno de los ID ingresado ya esta agregado en las debilidades.",List.of("")),
    WEAKNESSLIST_BYID_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"Uno de los ID ingresado no pertenece a ninguna debilidad",List.of("")),
   
    LIST_EMPTY(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST,"La lista de valores se encuentran vacios o no existen",List.of(""));

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
