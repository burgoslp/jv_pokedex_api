package com.pokedex.pokedex.services.interfaces;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;

public interface ITypeServices {
    JsonApiresponse findAll();
    JsonApiresponse findById(Long id);
}
