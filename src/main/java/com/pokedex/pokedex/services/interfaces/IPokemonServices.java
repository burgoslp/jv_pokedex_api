package com.pokedex.pokedex.services.interfaces;
import java.util.List;

import com.pokedex.pokedex.dtos.Pokemon.CreatePokemonDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;

public interface IPokemonServices {
    
    JsonApiresponse findAll();
    JsonApiresponse findAllByOrderByWeightDesc();
    JsonApiresponse findAllByOrderByWeightAsc();
    JsonApiresponse findAllByOrderByHeightDesc();
    JsonApiresponse findAllByOrderByHeightAsc();
    JsonApiresponse findById (Long id);
    JsonApiresponse findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code);

    JsonApiresponse save(CreatePokemonDto createPokemonDto);
    JsonApiresponse update(Long id,CreatePokemonDto createPokemonDto);
    JsonApiresponse delete(Long id);

    JsonApiresponse addType(Long pokemonId,List<Long> typeId);
    JsonApiresponse addweakness(Long pokemonId,List<Long> typeId);
}
