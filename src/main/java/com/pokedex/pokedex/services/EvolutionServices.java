package com.pokedex.pokedex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.repositories.IEvolutionRepository;
import com.pokedex.pokedex.services.interfaces.IEvolutionServices;
@Service
public class EvolutionServices implements IEvolutionServices{

    @Autowired
    IEvolutionRepository er;

    @Override
    public List<Evolution> findAll() {
       return (List<Evolution>) er.findAll();
    }

    @Override
    public Optional<Evolution> findById(Long id) {
      return er.findById(id);
    }

    @Override
    public Evolution save(Evolution evolution) {
      return er.save(evolution);
    }

    @Override
    public Optional<Evolution> delete(Long id) {
        Optional<Evolution> evolucionOptional= er.findById(id);

        evolucionOptional.ifPresent(evolution -> {
            er.delete(evolution);
        });
        return evolucionOptional;
    }

}
