package com.pokedex.pokedex.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pokedex.pokedex.models.Type;
@Repository
public interface ITypeRepository extends CrudRepository<Type,Long> {
    
}   
