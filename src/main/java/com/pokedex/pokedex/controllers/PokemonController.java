package com.pokedex.pokedex.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pokedex.pokedex.services.PokemonServices;
import dtos.Pokemon.PokemonDto;
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
    public List<PokemonDto> list() {
       return  ps.findAll();
    }  
    
    //lista todos los pokemons de mayor peso a menor peso
    @GetMapping("/weight/desc")
    public List<PokemonDto> listByOrderByWeightDesc() {
       return  ps.findAllByOrderByWeightDesc();
    }  

    //lista todos los pokemons menor peso a mayor peso
    @GetMapping("/weight/asc")
    public List<PokemonDto> listByOrderByWeightAsc() {
        return ps.findAllByOrderByWeightAsc();
    }
    
    //lista todos los pokemons de mayor altura a menor
    @GetMapping("/height/desc")
    public List<PokemonDto> listByOrderByHeightDesc() {
       return  ps.findAllByOrderByHeightDesc();
    }  

    //lista todos los pokemons de menor altura a mayor altura
    @GetMapping("/height/asc")
    public List<PokemonDto> listByOrderByHeightAsc() {
       return  ps.findAllByOrderByHeightAsc();
    } 
    
    //busqueda por id del pokemon y sus relaciones
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)  {
        Optional<PokemonDto> opokemonDto;
        Map<String,String> response= new HashMap<>();
        try {
            opokemonDto = ps.findById(id);
            return ResponseEntity.ok(opokemonDto.orElseThrow());
        } catch (Exception e) {
          
            response.put("estatus", "Not found");
            response.put("message", "No se ha encontrado el pokemon solicitado con ese ID.");
            return ResponseEntity.badRequest().body(response);
        }
      
    }
    //busqueda por el nombre o codigo del pokemon y sus relaciones
    @GetMapping("/nameorcode/{nameOrCode}")
    public ResponseEntity<?> getMethodName(@PathVariable String nameOrCode) {
        List<PokemonDto> PokemonDto =ps.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(nameOrCode, nameOrCode);
            Map<String,String> response= new HashMap<>();

        if(PokemonDto.isEmpty()){
            response.put("estatus", "Not found");
            response.put("message", "No se han encontrado coincidencias con ese valor");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); 
        }        
        return ResponseEntity.ok(PokemonDto);
    }
    

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PokemonDto PokemonDto, BindingResult result) {
        if(result.hasErrors()){
            return validation(result);
        }   
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.save(PokemonDto));
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody PokemonDto pokemonDto,BindingResult result) {
        if(result.hasErrors()){
            return validation(result);
        }              
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.update(id, pokemonDto));
    }
    
    private ResponseEntity<?> validation(BindingResult result){
        Map<String,String> errors= new HashMap<>();
        result.getFieldErrors().forEach(error ->{
            errors.put(error.getField(), "el campo "+error.getField()+": "+error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
