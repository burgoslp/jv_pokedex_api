package com.pokedex.pokedex.validations;
import org.springframework.beans.factory.annotation.Autowired;

import com.pokedex.pokedex.repositories.IEvolutionRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEvolutionCodeValidator implements ConstraintValidator<UniqueEvolutionCode, String>{


    @Autowired
    private IEvolutionRepository evolutionRepository;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        if(code == null || code.isEmpty()) {
            return true; // Si el código es nulo o vacío, no se valida
        }
        return  !evolutionRepository.existsByCode(code);
    }
    

}
