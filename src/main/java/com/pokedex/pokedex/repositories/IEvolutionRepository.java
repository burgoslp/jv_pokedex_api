package com.pokedex.pokedex.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokedex.pokedex.models.Evolution;
@Repository
public interface IEvolutionRepository extends CrudRepository<Evolution,Long>{
    List<Evolution> findAllByOrderByWeightDesc();
    List<Evolution> findAllByOrderByWeightAsc();
    List<Evolution> findAllByOrderByHeightDesc();
    List<Evolution> findAllByOrderByHeightAsc();
    List<Evolution> findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name,String code);
}
