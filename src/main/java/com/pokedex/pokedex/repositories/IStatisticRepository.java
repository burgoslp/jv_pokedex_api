package com.pokedex.pokedex.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokedex.pokedex.models.Statistic;
@Repository
public interface IStatisticRepository extends CrudRepository<Statistic,Long>{

}
