package com.pokedex.pokedex.services.interfaces;
import dtos.Pokemon.PokemonDto;
import dtos.json.JsonApiresponse;

public interface IPokemonServices {
    
    JsonApiresponse findAll();
    JsonApiresponse findAllByOrderByWeightDesc();
    JsonApiresponse findAllByOrderByWeightAsc();
    JsonApiresponse findAllByOrderByHeightDesc();
    JsonApiresponse findAllByOrderByHeightAsc();
    JsonApiresponse findById (Long id);
    JsonApiresponse findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code);

    JsonApiresponse save(PokemonDto evolution);
    JsonApiresponse update(Long id,PokemonDto evolution);
    JsonApiresponse delete(Long id);
}
