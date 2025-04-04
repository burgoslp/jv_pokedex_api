package com.pokedex.pokedex.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.services.EvolutionServices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/pokedex/evolution")
public class EvolutionController {

    @Autowired
    EvolutionServices es;

    @GetMapping()
    public ResponseEntity<JsonApiresponse> findAll() {
        return ResponseEntity.ok().body(es.findAll());
    }
    

   
}
