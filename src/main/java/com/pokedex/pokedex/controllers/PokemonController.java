package com.pokedex.pokedex.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pokedex.pokedex.dtos.Pokemon.CreatePokemonDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.services.PokemonServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/pokedex/pokemon")
public class PokemonController {
    @Autowired
    PokemonServices ps;

    //listado de todos los pokemons y sus relaciones
    @GetMapping
    public ResponseEntity<JsonApiresponse> list() {
       return  ResponseEntity.ok().body(ps.findAll());
    }  
    
    //lista todos los pokemons de mayor peso a menor peso
    @GetMapping("/weight/desc")
    public ResponseEntity<JsonApiresponse> listByOrderByWeightDesc() {
       return ResponseEntity.ok().body(ps.findAllByOrderByWeightDesc());
    }  

    //lista todos los pokemons menor peso a mayor peso
    @GetMapping("/weight/asc")
    public ResponseEntity<JsonApiresponse> listByOrderByWeightAsc() {
        return ResponseEntity.ok().body(ps.findAllByOrderByWeightAsc());
    }
    
    //lista todos los pokemons de mayor altura a menor
    @GetMapping("/height/desc")
    public ResponseEntity<JsonApiresponse> listByOrderByHeightDesc() {
       return ResponseEntity.ok().body(ps.findAllByOrderByHeightDesc());
    }  

    //lista todos los pokemons de menor altura a mayor altura
    @GetMapping("/height/asc")
    public ResponseEntity<JsonApiresponse> listByOrderByHeightAsc() {
       return ResponseEntity.ok().body( ps.findAllByOrderByHeightAsc());
    } 
    
    //busqueda por id del pokemon y sus relaciones
    @GetMapping("/{id}")
    public ResponseEntity<JsonApiresponse> findById(@PathVariable Long id)  {
        return ResponseEntity.ok(ps.findById(id));      
    }

    //busqueda por el nombre o codigo del pokemon y sus relaciones
    @GetMapping("/nameorcode/{nameOrCode}")
    public ResponseEntity<JsonApiresponse> findByNameOrCode(@PathVariable String nameOrCode) {       
        return ResponseEntity.ok(ps.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(nameOrCode, nameOrCode));
    }
    
    //crear un nuevo pokemon
    @PostMapping("/create")
    public ResponseEntity<JsonApiresponse> create(@Valid @RequestBody CreatePokemonDto CreatePokemonDto) {       
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.save(CreatePokemonDto));
    }
    
    //actualizar pokemon existente
    @PutMapping("update/{id}")
    public ResponseEntity<JsonApiresponse> update(@PathVariable Long id,@Valid @RequestBody CreatePokemonDto CreatePokemonDto) {                 
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.update(id, CreatePokemonDto));
    }
    //eliminar pokemon existente
    @DeleteMapping("delete/{id}")
    public ResponseEntity<JsonApiresponse>  delete(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.CREATED).body(ps.delete(id));
    }
    
}
