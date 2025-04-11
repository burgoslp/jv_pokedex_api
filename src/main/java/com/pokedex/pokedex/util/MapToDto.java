package com.pokedex.pokedex.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonDto;
import com.pokedex.pokedex.dtos.statistic.StatisticDto;
import com.pokedex.pokedex.dtos.type.TypeDto;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;
import com.pokedex.pokedex.models.Statistic;
import com.pokedex.pokedex.models.Type;
@Component
public class MapToDto { 
    //exporta un objeto PokemonDto
    public  PokemonDto pokemonToDto(Pokemon pokemon){
        return PokemonDto.builder()
                            .id(pokemon.getId())
                            .name(pokemon.getName())
                            .description(pokemon.getDescription())
                            .height(pokemon.getHeight())
                            .weight(pokemon.getWeight())
                            .code(pokemon.getCode())
                            .image(pokemon.getImage())
                            .build();
    }
    //exporta un objetos PokemonDto con relaciones
    public  PokemonDto pokemonRelatedToDto(Pokemon pokemon){
        return PokemonDto.builder()
                                .id(pokemon.getId())
                                .name(pokemon.getName())
                                .description(pokemon.getDescription())
                                .height(pokemon.getHeight())
                                .weight(pokemon.getWeight())
                                .code(pokemon.getCode())
                                .image(pokemon.getImage())
                                .evolutions(evolutionToDtoList(pokemon.getEvolutions()))
                                .types(typeToDtoList(pokemon.getTypes()))
                                .weaknesses(typeToDtoList(pokemon.getWeaknesses()))
                                .statistic(pokemon.getStatistic() != null ? statisticToDto(pokemon.getStatistic()):null)
                                .build();
    }
    //exporta una lista de objetos PokemonDto con relaciones
    public  List<PokemonDto> pokemonRelatedToDtoList(List<Pokemon> pokemons){
        List<PokemonDto> listPokemonDTO= new ArrayList<>();
        pokemons.forEach(evo ->{
            listPokemonDTO.add(pokemonRelatedToDto(evo)); 
        });
        return listPokemonDTO;
    }
    /*
     * 
     * 
     * 
    */   
    public  EvolutionDto evolutionToDto(Evolution evolution){
        return EvolutionDto.builder()
                            .id(evolution.getId())
                            .name(evolution.getName())
                            .description(evolution.getDescription())
                            .height(evolution.getHeight())
                            .weight(evolution.getWeight())
                            .code(evolution.getCode())
                            .image(evolution.getImage())
                            .build();
    } 

    public  EvolutionDto evolutionRelatedToDto(Evolution evolution){
        return EvolutionDto.builder()
                                    .id(evolution.getId())
                                    .name(evolution.getName())
                                    .description(evolution.getDescription())
                                    .height(evolution.getHeight())
                                    .weight(evolution.getWeight())
                                    .code(evolution.getCode())
                                    .image(evolution.getImage())
                                    .pokemon(pokemonToDto(evolution.getPokemon()))
                                    .types(typeToDtoList(evolution.getTypes()))
                                    .weaknesses(typeToDtoList(evolution.getWeaknesses()))
                                    .statistic(evolution.getStatistic() != null ? statisticToDto(evolution.getStatistic()):null)
                                    .build();
    } 

    public  List<EvolutionDto> evolutionToDtoList(List<Evolution> evolutions){
        List<EvolutionDto> listEvolutionDTO= new ArrayList<>();
        evolutions.forEach(evo ->{
            listEvolutionDTO.add(evolutionToDto(evo)); 
        });

        return listEvolutionDTO;
    }
    public  List<EvolutionDto> evolutionRelatedPokemonToDtoList(List<Evolution> evolutions){
        List<EvolutionDto> listEvolutionDTO= new ArrayList<>();
        evolutions.forEach(evo ->{
            listEvolutionDTO.add(evolutionRelatedToDto(evo)); 
        });
        return listEvolutionDTO;
    }
    /* 
     * 
     * 
     * 
     */
    //exporta un objeto TypeDto sin relaciones
    public TypeDto typeToDto(Type typeDto){
        return TypeDto.builder().id(typeDto.getId()).name(typeDto.getName()).description(typeDto.getDescription()).build();
    }

    public List<TypeDto> typeToDtoList(List<Type> types){
        List<TypeDto> typeDtoList= new ArrayList<>();

        types.forEach(tp -> {
            typeDtoList.add(typeToDto(tp));
        });

        return typeDtoList;
    } 
    /*
     * 
     * 
     * 
     * 
    */
    public StatisticDto statisticToDto(Statistic statistic){
        
        return StatisticDto.builder()
                            .id(statistic.getId())
                            .attack(statistic.getAttack())
                            .defence(statistic.getDefence())
                            .velocity(statistic.getVelocity())
                            .life(statistic.getLife())
                            .build();
    }

}
