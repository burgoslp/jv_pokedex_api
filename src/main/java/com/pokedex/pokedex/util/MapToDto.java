package com.pokedex.pokedex.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pokedex.pokedex.dtos.Evolution.EvolutionDetailsDto;
import com.pokedex.pokedex.dtos.Evolution.EvolutionSumaryDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonDetailsDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonSumaryDto;
import com.pokedex.pokedex.dtos.statistic.StatisticDto;
import com.pokedex.pokedex.dtos.type.TypeDto;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;
import com.pokedex.pokedex.models.Statistic;
import com.pokedex.pokedex.models.Type;
@Component
public class MapToDto { 
    //exporta un objeto PokemonDto
    public  PokemonSumaryDto pokemonToPokemonSumaryDto(Pokemon pokemon){
        return PokemonSumaryDto.builder()
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
    public  PokemonDetailsDto pokemonToPokemonDetailsDto(Pokemon pokemon){
        return PokemonDetailsDto.builder()
                                .id(pokemon.getId())
                                .name(pokemon.getName())
                                .description(pokemon.getDescription())
                                .height(pokemon.getHeight())
                                .weight(pokemon.getWeight())
                                .code(pokemon.getCode())
                                .image(pokemon.getImage())
                                .evolutions(evolutionListToEvolutionSumaryDtoList(pokemon.getEvolutions()))
                                .types(typeToDtoList(pokemon.getTypes()))
                                .weaknesses(typeToDtoList(pokemon.getWeaknesses()))
                                .statistic(pokemon.getStatistic() != null ? statisticToDto(pokemon.getStatistic()):null)
                                .build();
    }

    //exporta una lista de objetos PokemonDetailsDto esta tiene sus relaciones
    public  List<PokemonDetailsDto> pokemonListToPokemonDetailsDtoList(List<Pokemon> pokemons){
        List<PokemonDetailsDto> listPokemonDTO= new ArrayList<>();
        pokemons.forEach(evo ->{
            listPokemonDTO.add(pokemonToPokemonDetailsDto(evo)); 
        });
        return listPokemonDTO;
    }
    //esporta una lista de objetos PokemonSumaryDto esta no tiene relaciones
    public List<PokemonSumaryDto> pokemonListToPokemonSumaryDtoList(List<Pokemon> pokemons){

        List<PokemonSumaryDto> listPokemonDTO= new ArrayList<>();

        pokemons.forEach(poke ->{
            listPokemonDTO.add(pokemonToPokemonSumaryDto(poke)); 
        });

        return listPokemonDTO;
    }
    /*
     * 
     * 
     * 
    */   
    public  EvolutionSumaryDto evolutionToEvolutionSumaryDto(Evolution evolution){
        return EvolutionSumaryDto.builder()
                            .id(evolution.getId())
                            .name(evolution.getName())
                            .description(evolution.getDescription())
                            .height(evolution.getHeight())
                            .weight(evolution.getWeight())
                            .code(evolution.getCode())
                            .image(evolution.getImage())
                            .build();
    } 

    public  EvolutionDetailsDto evolutionToEvolutionDetailsDto(Evolution evolution){
        return EvolutionDetailsDto.builder()
                                    .id(evolution.getId())
                                    .name(evolution.getName())
                                    .description(evolution.getDescription())
                                    .height(evolution.getHeight())
                                    .weight(evolution.getWeight())
                                    .code(evolution.getCode())
                                    .image(evolution.getImage())
                                    .pokemon(pokemonToPokemonSumaryDto(evolution.getPokemon()))
                                    .types(typeToDtoList(evolution.getTypes()))
                                    .weaknesses(typeToDtoList(evolution.getWeaknesses()))
                                    .statistic(evolution.getStatistic() != null ? statisticToDto(evolution.getStatistic()):null)
                                    .build();
    } 

    public  List<EvolutionSumaryDto> evolutionListToEvolutionSumaryDtoList(List<Evolution> evolutions){
        List<EvolutionSumaryDto> listEvolutionSumaryDTO= new ArrayList<>();
        evolutions.forEach(evo ->{
            listEvolutionSumaryDTO.add(evolutionToEvolutionSumaryDto(evo)); 
        });

        return listEvolutionSumaryDTO;
    }
    public  List<EvolutionDetailsDto> evolutionListToEvolutionDetailsDtoList(List<Evolution> evolutions){
        List<EvolutionDetailsDto> listEvolutionDetailsDTO= new ArrayList<>();
        evolutions.forEach(evo ->{
            listEvolutionDetailsDTO.add(evolutionToEvolutionDetailsDto(evo)); 
        });
        return listEvolutionDetailsDTO;
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
