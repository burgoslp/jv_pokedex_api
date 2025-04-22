package com.pokedex.pokedex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.dtos.statistic.CreateStatisticEvolutionDto;
import com.pokedex.pokedex.dtos.statistic.CreateStatisticPokemonDto;
import com.pokedex.pokedex.services.StatisticService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/pokedex/statistic")
public class StatisticController {
    @Autowired
    StatisticService ss;

    @PostMapping("/create/pokemon")
    public ResponseEntity<JsonApiresponse> saveRelatedPokemon(@Valid @RequestBody CreateStatisticPokemonDto createStatisticPokemonDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ss.saveRelatedPokemon(createStatisticPokemonDto));
    }
    
    @PostMapping("/create/evolution")
    public ResponseEntity<JsonApiresponse> saveRelatedEvolution(@Valid @RequestBody CreateStatisticEvolutionDto createStatisticEvolutionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ss.saveRelatedEvolution(createStatisticEvolutionDto));
    }
    
    

}
