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
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonListToPokemonSumaryDtoList(pokemons)).build();
    }

    @Override
    public JsonApiresponse findAllByOrderByWeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByWeightDesc();
       return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonListToPokemonSumaryDtoList(pokemons)).build();

    }

    @Override
    public JsonApiresponse findAllByOrderByWeightAsc() {
        List<Pokemon> pokemons=pr.findAllByOrderByWeightAsc();
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonListToPokemonSumaryDtoList(pokemons)).build();
    }
    

    @Override
    public JsonApiresponse findAllByOrderByHeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByHeightDesc();
       return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonListToPokemonSumaryDtoList(pokemons)).build();
    }

    @Override
    public JsonApiresponse findAllByOrderByHeightAsc() {
        List<Pokemon> pokemons = pr.findAllByOrderByHeightAsc();
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonListToPokemonSumaryDtoList(pokemons)).build();
    }

    @Override
    public JsonApiresponse findById(Long id)  {
        Optional<Pokemon> pokemon= pr.findById(id); 
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonToPokemonDetailsDto(pokemon.orElseThrow(()->new APIException(APIError.POKEMON_BYID_NOT_FOUND)))).build();
      
    }

    @Override
    public JsonApiresponse  findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code) {
        List<Pokemon> pokemons=pr.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase("%"+name+"%","%"+code+"%");
        if (pokemons.isEmpty()) {
            throw new APIException(APIError.POKEMON_VALUE_NOT_FOUND);
        }
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.pokemonListToPokemonSumaryDtoList(pokemons)).build();
    }


    @Override
    public JsonApiresponse save(CreatePokemonDto createPokemonDto) {
     
        Pokemon pokemon = Pokemon.builder()
                                            .name(createPokemonDto.getName())
                                            .description(createPokemonDto.getDescription())
                                            .height(createPokemonDto.getHeight())
                                            .weight(createPokemonDto.getWeight())
                                            .code(createPokemonDto.getCode())
                                            .image(createPokemonDto.getImage())                                            
                                            .build();
        return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data(map.pokemonToPokemonSumaryDto(pr.save(pokemon))).build();
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


       return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data(map.pokemonToPokemonSumaryDto(pr.save(pokemon))).build();
    }

   

    @Override
    public JsonApiresponse addType(Long pokemonId, List<Long> typeIdList) {
        Pokemon pokemon = pr.findById(pokemonId).orElseThrow(()-> new APIException(APIError.POKEMON_BYID_NOT_FOUND));
        if(typeIdList ==null || typeIdList.isEmpty()){
            throw new APIException(APIError.LIST_EMPTY);
        }
        List<Type> typeList= new ArrayList<>();
        typeIdList.forEach(id ->{
            typeList.add(tr.findById(id).orElseThrow(()-> new APIException(APIError.TYPELIST_BYID_NOT_FOUND)));
        });
        pokemon.getTypes().addAll(typeList);    
        pr.save(pokemon);

        return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data("Los tipos se han agregado correctamente").build();
    }

    @Override
    public JsonApiresponse addweakness(Long pokemonId, List<Long> weaknessIdList) {
        Pokemon pokemon = pr.findById(pokemonId).orElseThrow(()-> new APIException(APIError.POKEMON_BYID_NOT_FOUND));
        if(weaknessIdList ==null || weaknessIdList.isEmpty()){
            throw new APIException(APIError.LIST_EMPTY);
        }
        List<Type> weaknessList= new ArrayList<>();
        weaknessIdList.forEach(id ->{
            weaknessList.add(tr.findById(id).orElseThrow(()-> new APIException(APIError.TYPELIST_BYID_NOT_FOUND)));
        });

        pokemon.getWeaknesses().addAll(weaknessList);
        pr.save(pokemon);
        return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data("Las debilidades se han agregado correctamente").build();
    }

    @Override
    public  JsonApiresponse delete(Long id) {
        Optional<Pokemon> optionalPokemon= pr.findById(id);
        
        optionalPokemon.ifPresentOrElse(pokemon -> {
            pr.delete(pokemon);
        },()->{
            throw new APIException(APIError.POKEMON_BYID_NOT_FOUND);
        });

        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data("Pokemon eliminado con exito").build();
    }

    
}
