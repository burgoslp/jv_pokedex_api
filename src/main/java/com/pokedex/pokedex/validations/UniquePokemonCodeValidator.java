package com.pokedex.pokedex.validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pokedex.pokedex.repositories.IPokemonRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniquePokemonCodeValidator implements ConstraintValidator<UniquePokemonCode, String>{

    @Autowired
    private IPokemonRepository pokemonRepository;


    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
       
        if(code == null || code.isEmpty()) {
            return true; // Si el código es nulo o vacío, no se valida
        }


        return !pokemonRepository.existsByCode(code);
    }
}   
