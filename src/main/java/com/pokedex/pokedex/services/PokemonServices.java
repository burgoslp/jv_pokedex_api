package com.pokedex.pokedex.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.repositories.IPokemonRepository;
import com.pokedex.pokedex.repositories.ITypeRepository;
import com.pokedex.pokedex.services.interfaces.IPokemonServices;
import com.pokedex.pokedex.util.MapToDto;
import com.pokedex.pokedex.dtos.Pokemon.CreatePokemonDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.exceptions.APIError;
import com.pokedex.pokedex.exceptions.APIException;
import com.pokedex.pokedex.models.Pokemon;
import com.pokedex.pokedex.models.Type;


@Service
public class PokemonServices implements IPokemonServices {

    @Autowired
    private IPokemonRepository pr;
    @Autowired
    private ITypeRepository tr;
    @Autowired
    private MapToDto map;
    
    @Override
    public JsonApiresponse findAll() {       
        List<Pokemon> pokemons =(List<Pokemon>)pr.findAll();
        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDtoList(pokemons));
    }

    @Override
    public JsonApiresponse findAllByOrderByWeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByWeightDesc();
       return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDtoList(pokemons));

    }

    @Override
    public JsonApiresponse findAllByOrderByWeightAsc() {
        List<Pokemon> pokemons=pr.findAllByOrderByWeightAsc();
        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDtoList(pokemons));
    }
    

    @Override
    public JsonApiresponse findAllByOrderByHeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByHeightDesc();
       return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDtoList(pokemons));
    }

    @Override
    public JsonApiresponse findAllByOrderByHeightAsc() {
        List<Pokemon> pokemons = pr.findAllByOrderByHeightAsc();
        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDtoList(pokemons));
    }

    @Override
    public JsonApiresponse findById(Long id)  {
        Optional<Pokemon> pokemon= pr.findById(id); 
        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDto(pokemon.orElseThrow(()->new APIException(APIError.POKEMON_BYID_NOT_FOUND))));
      
    }

    @Override
    public JsonApiresponse  findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code) {
        List<Pokemon> pokemons=pr.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase("%"+name+"%","%"+code+"%");
        if (pokemons.isEmpty()) {
            throw new APIException(APIError.POKEMON_VALUE_NOT_FOUND);
        }
        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonRelatedToDtoList(pokemons));
    }


    @Override
    public JsonApiresponse save(CreatePokemonDto CreatePokemonDto) {
        List<Type> types= new ArrayList<>();

        CreatePokemonDto.getTypeIdList().forEach(id ->{
           types.add(tr.findById(id).orElseThrow(()-> new APIException(APIError.TYPELIST_BYID_NOT_FOUND)));
        });

        Pokemon pokemon = Pokemon.builder()
                                            .name(CreatePokemonDto.getName())
                                            .description(CreatePokemonDto.getDescription())
                                            .height(CreatePokemonDto.getHeight())
                                            .weight(CreatePokemonDto.getWeight())
                                            .code(CreatePokemonDto.getCode())
                                            .image(CreatePokemonDto.getImage())
                                            .types(types)
                                            .build();
        
        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonToDto(pr.save(pokemon)));
    }

    @Override
    public JsonApiresponse update(Long id, CreatePokemonDto CreatePokemonDto) {
       Pokemon pokemon= pr.findById(id).orElseThrow(()-> new APIException(APIError.POKEMON_BYID_NOT_FOUND));

       pokemon.setName(CreatePokemonDto.getName() != null ? CreatePokemonDto.getName() : pokemon.getName());
       pokemon.setName(CreatePokemonDto.getDescription() != null ? CreatePokemonDto.getDescription() : pokemon.getDescription());
       pokemon.setHeight(CreatePokemonDto.getHeight() != null ? CreatePokemonDto.getHeight() : pokemon.getHeight());
       pokemon.setWeight(CreatePokemonDto.getWeight() != null ? CreatePokemonDto.getWeight() : pokemon.getWeight());
       pokemon.setCode(CreatePokemonDto.getCode() != null ? CreatePokemonDto.getCode() : pokemon.getCode());
       pokemon.setImage(CreatePokemonDto.getImage() != null ? CreatePokemonDto.getImage() : pokemon.getImage());


       return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonToDto(pr.save(pokemon)));
    }

    @Override
    public  JsonApiresponse delete(Long id) {
        Optional<Pokemon> optionalPokemon= pr.findById(id);
        
        optionalPokemon.ifPresentOrElse(evolution -> {
            pr.delete(evolution);
        },()->{
            throw new APIException(APIError.POKEMON_BYID_NOT_FOUND);
        });

        return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),map.pokemonToDto(optionalPokemon.get()));
    }
}
