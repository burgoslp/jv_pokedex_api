package com.pokedex.pokedex.util;

import java.util.ArrayList;
import java.util.List;

import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;
import com.pokedex.pokedex.dtos.Pokemon.PokemonDto;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;

public class MapToDto {

    public static PokemonDto pokemonToDto(Pokemon pokemon){

        PokemonDto pokemonDto= new PokemonDto();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setDescription(pokemon.getDescription());
        pokemonDto.setHeight(pokemon.getHeight());
        pokemonDto.setWeight(pokemon.getWeight());
        pokemonDto.setImage(pokemon.getImage());

        return pokemonDto;
    }

    public static PokemonDto pokemonRelatedToDto(Pokemon pokemon){
        PokemonDto pokemonDto= new PokemonDto();
        List<EvolutionDto> evolutionDtos= new ArrayList<>();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setDescription(pokemon.getDescription());
        pokemonDto.setHeight(pokemon.getHeight());
        pokemonDto.setWeight(pokemon.getWeight());
        pokemonDto.setImage(pokemon.getImage());

        //recorremos las evoluciones del modelo pokemon para setearlas a una instancia evolutioDto
        if(pokemon.getEvolutions() != null){
            for (Evolution evolution : pokemon.getEvolutions()) {          

                evolutionDtos.add(evolutionToDto(evolution));
            }
            pokemonDto.setEvolutions(evolutionDtos);
       }


        return pokemonDto;
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
    /*
     * 
     * 
     * 
     * 
     * 
     * 
    */
    // convierte una entidad evolution a un evolutionDto sin relaciones
    public static EvolutionDto evolutionToDto(Evolution evolution){

            EvolutionDto evolutionDto = new EvolutionDto();   
    
            evolutionDto.setId(evolution.getId());
            evolutionDto.setName(evolution.getName());
            evolutionDto.setDescription(evolution.getDescription());
            evolutionDto.setHeight(evolution.getHeight());
            evolutionDto.setWeight(evolution.getWeight());
            evolutionDto.setCode(evolution.getCode());
            evolutionDto.setImage(evolution.getImage());
    
            return evolutionDto;

    } 

    // convierte una entidad evolution a un evolutionDto con sus respectivas relaciones
    public static EvolutionDto evolutionRelatedToDto(Evolution evolution){

        EvolutionDto evolutionDto = new EvolutionDto();   
        
        evolutionDto.setId(evolution.getId());
        evolutionDto.setName(evolution.getName());
        evolutionDto.setDescription(evolution.getDescription());
        evolutionDto.setHeight(evolution.getHeight());
        evolutionDto.setWeight(evolution.getWeight());
        evolutionDto.setCode(evolution.getCode());
        evolutionDto.setImage(evolution.getImage());

        //tranformamos la entidad pokemon a pokemondto 
        evolutionDto.setPokemon(pokemonToDto(evolution.getPokemon()));

        return evolutionDto;

    } 
}
