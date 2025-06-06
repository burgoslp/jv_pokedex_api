package com.pokedex.pokedex.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.pokedex.pokedex.dtos.Evolution.CreateEvolutionDto;
import com.pokedex.pokedex.dtos.Evolution.EvolutionUpdateDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.services.EvolutionServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/pokedex/evolution")
public class EvolutionController {

    @Autowired
    EvolutionServices es;

    @GetMapping()
    public ResponseEntity<JsonApiresponse> findAll() {
        return ResponseEntity.ok().body(es.findAll());
    }
    
    //lista todos las evoluciones de mayor peso a menor peso
    @GetMapping("/weight/desc")
    public ResponseEntity<JsonApiresponse> listByOrderByWeightDesc() {
       return ResponseEntity.ok().body(es.findAllByOrderByWeightDesc());
    }  

    //lista todos las evoluciones menor peso a mayor peso
    @GetMapping("/weight/asc")
    public ResponseEntity<JsonApiresponse> listByOrderByWeightAsc() {
        return ResponseEntity.ok().body(es.findAllByOrderByWeightAsc());
    }
    
    //lista todos las evoluciones de mayor altura a menor
    @GetMapping("/height/desc")
    public ResponseEntity<JsonApiresponse> listByOrderByHeightDesc() {
       return ResponseEntity.ok().body(es.findAllByOrderByHeightDesc());
    }  

    //lista todos las evoluciones de menor altura a mayor altura
    @GetMapping("/height/asc")
    public ResponseEntity<JsonApiresponse> listByOrderByHeightAsc() {
       return ResponseEntity.ok().body(es.findAllByOrderByHeightAsc());
    } 

    //busqueda por id del pokemon y sus relaciones
    @GetMapping("/{id}")
    public ResponseEntity<JsonApiresponse> findById(@PathVariable Long id)  {
        return ResponseEntity.ok(es.findById(id));      
    }

    //busqueda por el nombre o codigo del pokemon y sus relaciones
    @GetMapping("/nameorcode/{nameOrCode}")
    public ResponseEntity<JsonApiresponse> findByNameOrCode(@PathVariable String nameOrCode) {       
        return ResponseEntity.ok(es.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(nameOrCode, nameOrCode));
    }

    //crear evolución de un pokemon
    @PostMapping("/create")
    public ResponseEntity<JsonApiresponse> create(@Valid @RequestBody CreateEvolutionDto CreateEvolutionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(es.save(CreateEvolutionDto));
    }

     //agregar tipos  a la evolución
    @PostMapping("/add/{id}/type")
    public ResponseEntity<JsonApiresponse> addType(@PathVariable Long id,@Valid @RequestBody List<Long> typeIdList) {       
        return ResponseEntity.status(HttpStatus.CREATED).body(es.addType(id, typeIdList));
    }

    //agregar debilidades a la evolución
    @PostMapping("/add/{id}/weakness")
    public ResponseEntity<JsonApiresponse> addWeakness(@PathVariable Long id,@Valid @RequestBody List<Long> weaknessIdList) {       
        return ResponseEntity.status(HttpStatus.CREATED).body(es.addweakness(id, weaknessIdList));
    }

    //actualizar evolución de un pokemon
    @PutMapping("/update/{id}")
    public ResponseEntity<JsonApiresponse> create(@PathVariable Long id,@Valid @RequestBody EvolutionUpdateDto evolutionUpdateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(es.update(id,evolutionUpdateDto));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JsonApiresponse> delete(@PathVariable Long id){

        return ResponseEntity.ok().body(es.delete(id));
    }
}
