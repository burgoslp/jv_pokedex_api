package com.pokedex.pokedex.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.pokedex.pokedex.models.Evolution;

public interface IEvolutionServices {

    List<Evolution> findAll();
    Optional<Evolution> findById(Long id);
    Evolution save(Evolution evolution);
    Optional<Evolution> delete(Long id);
}
