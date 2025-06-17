package com.pokedex.pokedex.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.repositories.IPokemonRepository;
import com.pokedex.pokedex.repositories.ITypeRepository;
import com.pokedex.pokedex.services.interfaces.IPokemonServices;
import com.pokedex.pokedex.util.MapToDto;
import com.pokedex.pokedex.dtos.Pokemon.CreatePokemonDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonUpdateDto;
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
    public JsonApiresponse update(Long id, PokemonUpdateDto pokemonUpdateDto) {
       Pokemon pokemon= pr.findById(id).orElseThrow(()-> new APIException(APIError.POKEMON_BYID_NOT_FOUND));

       pokemon.setName(pokemonUpdateDto.getName() != null ? pokemonUpdateDto.getName() : pokemon.getName());
       pokemon.setDescription(pokemonUpdateDto.getDescription() != null ? pokemonUpdateDto.getDescription() : pokemon.getDescription());
       pokemon.setHeight(pokemonUpdateDto.getHeight() != null ? pokemonUpdateDto.getHeight() : pokemon.getHeight());
       pokemon.setWeight(pokemonUpdateDto.getWeight() != null ? pokemonUpdateDto.getWeight() : pokemon.getWeight());
       pokemon.setCode(pokemonUpdateDto.getCode() != null ? pokemonUpdateDto.getCode() : pokemon.getCode());
       pokemon.setImage(pokemonUpdateDto.getImage() != null ? pokemonUpdateDto.getImage() : pokemon.getImage());


       return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data(map.pokemonToPokemonSumaryDto(pr.save(pokemon))).build();
    }

   

    @Override
    public JsonApiresponse addType(Long pokemonId, Set<Long> typeIdList) {
        Pokemon pokemon = pr.findById(pokemonId).orElseThrow(()-> new APIException(APIError.POKEMON_BYID_NOT_FOUND));
        if(typeIdList ==null || typeIdList.isEmpty()){
            throw new APIException(APIError.LIST_EMPTY);
        }
        List<Type> typeList= new ArrayList<>();
        typeIdList.forEach(id ->{
            Type type = tr.findById(id).orElseThrow(()-> new APIException(APIError.TYPELIST_BYID_NOT_FOUND));
            //verificar si el tipo ya existe en la lista de tipos
            if(pokemon.getTypes().stream().anyMatch(t -> t.getId().equals(type.getId()))){
                throw new APIException(APIError.TYPElIST_BYID_COINCIDENCE);
            }

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

            Type type=tr.findById(id).orElseThrow(()-> new APIException(APIError.WEAKNESSLIST_BYID_NOT_FOUND));

            //verificar si el tipo ya existe en la lista de debilidades
            if(pokemon.getWeaknesses().stream().anyMatch(t -> t.getId().equals(type.getId()))){
                throw new APIException(APIError.WEAKNESSlIST_BYID_COINCIDENCE);

            }
            weaknessList.add(type);
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
