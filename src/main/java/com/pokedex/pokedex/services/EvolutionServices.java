package com.pokedex.pokedex.services;

import static com.pokedex.pokedex.util.MapToDto.evolutionToDtoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.repositories.IEvolutionRepository;
import com.pokedex.pokedex.services.interfaces.IEvolutionServices;

@Service
public class EvolutionServices implements IEvolutionServices{

    @Autowired
    IEvolutionRepository er;

    @Override
    public JsonApiresponse findAll() {
      List<Evolution> evolutions= (List<Evolution>) er.findAll();
      return new JsonApiresponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),evolutionToDtoList(evolutions));
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
