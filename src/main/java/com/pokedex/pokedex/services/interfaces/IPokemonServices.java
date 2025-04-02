package com.pokedex.pokedex.services.interfaces;

import java.util.List;
import java.util.Optional;
import com.pokedex.pokedex.models.Pokemon;

import dtos.Pokemon.PokemonDto;

public interface IPokemonServices {
    
    List<PokemonDto> findAll();
    List<PokemonDto> findAllByOrderByWeightDesc();
    List<PokemonDto> findAllByOrderByWeightAsc();
    List<PokemonDto> findAllByOrderByHeightDesc();
    List<PokemonDto> findAllByOrderByHeightAsc();
    Optional<PokemonDto> findById (Long id) throws Exception;
    List<PokemonDto> findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code);

    PokemonDto save(PokemonDto evolution);
    PokemonDto update(Long id,PokemonDto evolution);
    Optional<Pokemon> delete(Long id);
}
