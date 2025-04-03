package com.pokedex.pokedex.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.repositories.IPokemonRepository;
import com.pokedex.pokedex.services.interfaces.IPokemonServices;
import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.exceptions.APIError;
import com.pokedex.pokedex.exceptions.APIException;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;


@Service
public class PokemonServices implements IPokemonServices {

    @Autowired
    IPokemonRepository pr;
    
    @Override
    public JsonApiresponse findAll() {       
        Iterable<Pokemon> pokemons =pr.findAll();
        List<PokemonDto> pokemonDtos= new ArrayList<>();
        JsonApiresponse jsonApiresponse = new JsonApiresponse();

        jsonApiresponse.setCode(HttpStatus.OK.value());
        jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());

        pokemons.forEach(poke ->{
            pokemonDtos.add(pokemonToDto(poke));
        });

        jsonApiresponse.setData(pokemonDtos);
        return jsonApiresponse;
    }

    @Override
    public JsonApiresponse findAllByOrderByWeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByWeightDesc();
       List<PokemonDto> pokemonDtos= new ArrayList<>();
       JsonApiresponse jsonApiresponse = new JsonApiresponse();

       jsonApiresponse.setCode(HttpStatus.OK.value());
       jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());

       pokemons.forEach(poke ->{
           pokemonDtos.add(pokemonToDto(poke));
       });

       jsonApiresponse.setData(pokemonDtos);       
       return jsonApiresponse;
    }

    @Override
    public JsonApiresponse findAllByOrderByWeightAsc() {
        List<Pokemon> pokemons=pr.findAllByOrderByWeightAsc();
        List<PokemonDto> pokemonDtos= new ArrayList<>();
        JsonApiresponse jsonApiresponse= new JsonApiresponse();
        jsonApiresponse.setCode(HttpStatus.OK.value());
        jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
        pokemons.forEach(poke ->{
            pokemonDtos.add(pokemonToDto(poke));
        });

        jsonApiresponse.setData(pokemonDtos);
        return jsonApiresponse;
    }
    

    @Override
    public JsonApiresponse findAllByOrderByHeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByHeightDesc();
       List<PokemonDto> pokemonDtos= new ArrayList<>();
       JsonApiresponse jsonApiresponse = new JsonApiresponse();
        
       jsonApiresponse.setCode(HttpStatus.OK.value());
       jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
       pokemons.forEach(poke ->{
           pokemonDtos.add(pokemonToDto(poke));
       });

       jsonApiresponse.setData(pokemonDtos);
       return jsonApiresponse;
    }

    @Override
    public JsonApiresponse findAllByOrderByHeightAsc() {
        List<Pokemon> pokemons = pr.findAllByOrderByHeightAsc();
        List<PokemonDto> pokemonDtos= new ArrayList<>();
        JsonApiresponse jsonApiresponse= new JsonApiresponse();
        jsonApiresponse.setCode(HttpStatus.OK.value());
        jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
        
        pokemons.forEach(poke ->{
            pokemonDtos.add(pokemonToDto(poke));
        });

        jsonApiresponse.setData(pokemonDtos);       
        return jsonApiresponse;
    }

    @Override
    public JsonApiresponse findById(Long id)  {
        Optional<Pokemon> pokemon= pr.findById(id); 
        JsonApiresponse jsonApiresponse = new JsonApiresponse();

        try {
            jsonApiresponse.setCode(HttpStatus.OK.value());
            jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
            jsonApiresponse.setData(pokemonToDto(pokemon.orElseThrow()));
            return jsonApiresponse;
        } catch (Exception ex) {

            throw new APIException(APIError.POKEMON_BYID_NOT_FOUND);
        }
      
    }

    @Override
    public JsonApiresponse  findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code) {
        
        List<Pokemon> pokemons=pr.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase("%"+name+"%","%"+code+"%");
        List<PokemonDto> pokemonsDto= new ArrayList<>();
        JsonApiresponse jsonApiresponse= new JsonApiresponse();

        if (pokemons.isEmpty()) {
            throw new APIException(APIError.POKEMON_VALUE_NOT_FOUND);
        }

        jsonApiresponse.setCode(HttpStatus.OK.value());
        jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
        pokemons.forEach(poke->{
            pokemonsDto.add(pokemonToDto(poke));
        });
       
        jsonApiresponse.setData(pokemonsDto);     

        return jsonApiresponse;
    }

    

    @Override
    public JsonApiresponse save(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        JsonApiresponse jsonApiresponse= new JsonApiresponse();
        pokemon.setName(pokemonDto.getName());
        pokemon.setHeight(pokemonDto.getHeight());
        pokemon.setWeight(pokemonDto.getWeight());
        pokemon.setCode(pokemonDto.getCode());
        pokemon.setImage(pokemonDto.getImage());
        
        jsonApiresponse.setCode(HttpStatus.OK.value());
        jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
        jsonApiresponse.setData(pokemonToDto(pr.save(pokemon)));
        
        return jsonApiresponse;
    }

    @Override
    public JsonApiresponse update(Long id, PokemonDto pokemonDto) {
       Optional<Pokemon> originalPokemon= pr.findById(id);
       JsonApiresponse jsonApiresponse= new JsonApiresponse();

       if(!originalPokemon.isPresent()){
            throw new APIException(APIError.POKEMON_BYID_NOT_FOUND);
       }

       Pokemon updatePokemon=originalPokemon.map(poke ->{
            Pokemon pokemon = poke;
            // Asignar usando operador ternario
            pokemon.setName(pokemonDto.getName() != null ? pokemonDto.getName() : poke.getName());
            pokemon.setHeight(pokemonDto.getHeight() != null ? pokemonDto.getHeight() : poke.getHeight());
            pokemon.setWeight(pokemonDto.getWeight() != null ? pokemonDto.getWeight() : poke.getWeight());
            pokemon.setCode(pokemonDto.getCode() != null ? pokemonDto.getCode() : poke.getCode());
            pokemon.setImage(pokemonDto.getImage() != null ? pokemonDto.getImage() : poke.getImage());
            return pr.save(pokemon);
       }).orElseThrow();

       jsonApiresponse.setCode(HttpStatus.OK.value());
       jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
       jsonApiresponse.setData(pokemonToDto(updatePokemon));

       return jsonApiresponse;
    }

    @Override
    public  JsonApiresponse delete(Long id) {
        Optional<Pokemon> optionalPokemon= pr.findById(id);
        JsonApiresponse jsonApiresponse=new JsonApiresponse();
        
        optionalPokemon.ifPresentOrElse(evolution -> {
            pr.delete(evolution);
        },()->{
            throw new APIException(APIError.POKEMON_BYID_NOT_FOUND);
        });

        jsonApiresponse.setCode(HttpStatus.OK.value());
        jsonApiresponse.setMessage(HttpStatus.OK.getReasonPhrase());
        jsonApiresponse.setData(pokemonToDto(optionalPokemon.get()));

        return jsonApiresponse;
    }


    private PokemonDto pokemonToDto(Pokemon pokemon){

        PokemonDto pokemonDto= new PokemonDto();
        //intanciar lista de evolucionDto para agregar a nuesto pokemonDto todas las evoluciones del modelo pokemon
        List<EvolutionDto> evolutionDtos= new ArrayList<>();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setHeight(pokemon.getHeight());
        pokemonDto.setWeight(pokemon.getWeight());
        pokemonDto.setCode(pokemon.getCode());
        pokemonDto.setImage(pokemon.getImage());

        //recorremos las evoluciones del modelo pokemon para setearlas a una instancia evolutioDto
        if(pokemon.getEvolutions() != null){
            for (Evolution evolution : pokemon.getEvolutions()) {          

                evolutionDtos.add(EvolutionToDto(evolution));
            }
            pokemonDto.setEvolutions(evolutionDtos);
       }
        return pokemonDto;
    }

    private EvolutionDto EvolutionToDto(Evolution evolution){

        EvolutionDto evolutionDto = new EvolutionDto();   

        evolutionDto.setId(evolution.getId());
        evolutionDto.setName(evolution.getName());
        evolutionDto.setHeight(evolution.getHeight());
        evolutionDto.setWeight(evolution.getWeight());
        evolutionDto.setCode(evolution.getCode());
        evolutionDto.setImage(evolution.getImage());

        return evolutionDto;
    }

   
   
}
