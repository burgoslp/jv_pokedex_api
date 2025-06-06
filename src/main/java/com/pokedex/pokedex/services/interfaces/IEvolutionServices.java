package com.pokedex.pokedex.services.interfaces;
import java.util.List;

import com.pokedex.pokedex.dtos.Evolution.CreateEvolutionDto;
import com.pokedex.pokedex.dtos.Evolution.EvolutionUpdateDto;
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
    JsonApiresponse update(Long id,EvolutionUpdateDto evolutionUpdateDTO);
    JsonApiresponse delete(Long id);

    JsonApiresponse addType(Long evolutionId,List<Long> typeId);
    JsonApiresponse addweakness(Long evolutionId,List<Long> typeId);
}
