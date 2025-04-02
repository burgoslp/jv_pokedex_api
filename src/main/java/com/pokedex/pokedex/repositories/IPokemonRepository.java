package com.pokedex.pokedex.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pokedex.pokedex.models.Pokemon;
@Repository
public interface IPokemonRepository extends CrudRepository<Pokemon,Long> {

    List<Pokemon> findAllByOrderByWeightDesc();
    List<Pokemon> findAllByOrderByWeightAsc();
    List<Pokemon> findAllByOrderByHeightDesc();
    List<Pokemon> findAllByOrderByHeightAsc();
    List<Pokemon> findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name,String code);
    

}
