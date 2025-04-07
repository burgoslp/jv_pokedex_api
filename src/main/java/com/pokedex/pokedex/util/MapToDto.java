package com.pokedex.pokedex.util;

import java.util.ArrayList;
import java.util.List;

import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonDto;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;

public class MapToDto {
    public static PokemonDto pokemonToDto(Pokemon pokemon){
        return PokemonDto.builder().id(pokemon.getId()).name(pokemon.getName()).description(pokemon.getDescription()).height(pokemon.getHeight()).weight(pokemon.getWeight()).code(pokemon.getCode()).image(pokemon.getImage()).build();
    }

    public static PokemonDto pokemonRelatedToDto(Pokemon pokemon){
        List<EvolutionDto> evolutionDtos= new ArrayList<>();
    
        for (Evolution evolution : pokemon.getEvolutions()) {          

            evolutionDtos.add(evolutionToDto(evolution));
        }

        return PokemonDto.builder().id(pokemon.getId()).name(pokemon.getName()).description(pokemon.getDescription()).height(pokemon.getHeight()).weight(pokemon.getWeight()).code(pokemon.getCode()).image(pokemon.getImage()).evolutions(evolutionDtos).build();
    }

    public static List<PokemonDto> pokemonToDtoList(List<Pokemon> pokemons){
        List<PokemonDto> listPokemonDTO= new ArrayList<>();
        pokemons.forEach(evo ->{
            listPokemonDTO.add(pokemonToDto(evo)); 
        });

        return listPokemonDTO;
    }
    public static List<PokemonDto> pokemonRelatedToDtoList(List<Pokemon> pokemons){
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
    public static EvolutionDto evolutionToDto(Evolution evolution){
        return EvolutionDto.builder().id(evolution.getId()).name(evolution.getName()).description(evolution.getDescription()).height(evolution.getHeight()).weight(evolution.getWeight()).code(evolution.getCode()).image(evolution.getImage()).build();
    } 

    public static EvolutionDto evolutionRelatedToDto(Evolution evolution){
        return EvolutionDto.builder().id(evolution.getId()).name(evolution.getName()).description(evolution.getDescription()).height(evolution.getHeight()).weight(evolution.getWeight()).code(evolution.getCode()).image(evolution.getImage()).pokemon(pokemonToDto(evolution.getPokemon())).build();
    } 

    public static List<EvolutionDto> evolutionToDtoList(List<Evolution> evolutions){
        List<EvolutionDto> listEvolutionDTO= new ArrayList<>();
        evolutions.forEach(evo ->{
            listEvolutionDTO.add(evolutionToDto(evo)); 
        });

        return listEvolutionDTO;
    }
    public static List<EvolutionDto> evolutionRelatedPokemonToDtoList(List<Evolution> evolutions){
        List<EvolutionDto> listEvolutionDTO= new ArrayList<>();
        evolutions.forEach(evo ->{
            listEvolutionDTO.add(evolutionRelatedToDto(evo)); 
        });
        return listEvolutionDTO;
    }
}
