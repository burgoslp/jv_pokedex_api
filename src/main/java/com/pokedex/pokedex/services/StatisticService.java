package com.pokedex.pokedex.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.dtos.statistic.CreateStatisticEvolutionDto;
import com.pokedex.pokedex.dtos.statistic.CreateStatisticPokemonDto;
import com.pokedex.pokedex.exceptions.APIError;
import com.pokedex.pokedex.exceptions.APIException;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;
import com.pokedex.pokedex.models.Statistic;
import com.pokedex.pokedex.repositories.IEvolutionRepository;
import com.pokedex.pokedex.repositories.IPokemonRepository;
import com.pokedex.pokedex.repositories.IStatisticRepository;
import com.pokedex.pokedex.services.interfaces.IStatisticService;
@Service
public class StatisticService  implements IStatisticService {
    @Autowired
    IStatisticRepository sr;

    @Autowired
    IPokemonRepository pr;

    @Autowired
    IEvolutionRepository er;

    @Override
    public JsonApiresponse saveRelatedPokemon(CreateStatisticPokemonDto createStatisticPokemonDto) {
        Pokemon pokemon = pr.findById(createStatisticPokemonDto.getPokemonId()).orElseThrow(()-> new APIException(APIError.POKEMON_BYID_NOT_FOUND));

        Statistic statistic= Statistic.builder()
                                        .attack(createStatisticPokemonDto.getAttack())
                                        .defence(createStatisticPokemonDto.getDefence())
                                        .velocity(createStatisticPokemonDto.getVelocity())
                                        .life(createStatisticPokemonDto.getLife())
                                        .pokemon(pokemon)
                                        .build();

       return new JsonApiresponse(HttpStatus.CREATED.value(),HttpStatus.CREATED.getReasonPhrase(),sr.save(statistic));
    }

    @Override
    public JsonApiresponse saveRelatedEvolution(CreateStatisticEvolutionDto createStatisticEvolutionDto) {
        Evolution evolution = er.findById(createStatisticEvolutionDto.getEvolutionId()).orElseThrow(()-> new APIException(APIError.EVOLUTION_BYID_NOT_FOUND));

        Statistic statistic= Statistic.builder()
                                        .attack(createStatisticEvolutionDto.getAttack())
                                        .defence(createStatisticEvolutionDto.getDefence())
                                        .velocity(createStatisticEvolutionDto.getVelocity())
                                        .life(createStatisticEvolutionDto.getLife())
                                        .evolution(evolution)
                                        .build();

       return new JsonApiresponse(HttpStatus.CREATED.value(),HttpStatus.CREATED.getReasonPhrase(),sr.save(statistic));
    }  


}
