package com.pokedex.pokedex.services.interfaces;
import com.pokedex.pokedex.dtos.Evolution.CreateEvolutionDto;
import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;

public interface IEvolutionServices {

    JsonApiresponse findAll();
    JsonApiresponse findAllByOrderByWeightDesc();
    JsonApiresponse findAllByOrderByWeightAsc();
    JsonApiresponse findAllByOrderByHeightDesc();
    JsonApiresponse findAllByOrderByHeightAsc();
    JsonApiresponse findById(Long id);
    JsonApiresponse findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code);
    JsonApiresponse save(CreateEvolutionDto CreateevolutionDTO);
    JsonApiresponse update(Long id,EvolutionDto evolutionDTO);
    JsonApiresponse delete(Long id);
}
