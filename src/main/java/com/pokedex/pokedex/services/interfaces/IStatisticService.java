package com.pokedex.pokedex.services.interfaces;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.dtos.statistic.CreateStatisticEvolutionDto;
import com.pokedex.pokedex.dtos.statistic.CreateStatisticPokemonDto;

public interface IStatisticService {
    JsonApiresponse saveRelatedPokemon(CreateStatisticPokemonDto createStatisticPokemonDto);
    JsonApiresponse saveRelatedEvolution(CreateStatisticEvolutionDto createStatisticEvolutionDto);
}
