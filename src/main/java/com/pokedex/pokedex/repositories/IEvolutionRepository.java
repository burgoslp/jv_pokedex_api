package com.pokedex.pokedex.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokedex.pokedex.models.Evolution;
@Repository
public interface IEvolutionRepository extends CrudRepository<Evolution,Long>{

}
