package com.pokedex.pokedex.dtos.Evolution;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateEvolutionDto {
    @NotBlank
    @Size(min = 1, max = 20)
    private String name;
    
    @Column(length = 1000)
    @NotBlank
    @Size(min=1, message="debes agregar una descripción")   
    private String description;
    
    @NotNull
    private Double height;
    
    @NotNull
    private Double weight;
    
    @NotNull
    @Size(min=5, max = 10, message = "El formato del codigo es de #0000")
    private String code;
    
    @NotBlank
    private String image;
    
    @NotNull
    private Long pokemonId;

    @NotNull
    private List<Long> typeIdList;

}
