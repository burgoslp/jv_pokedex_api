package com.pokedex.pokedex.dtos.Pokemon;
import java.util.List;
import com.pokedex.pokedex.dtos.Evolution.EvolutionDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PokemonDto {
    private Long id;
    @NotBlank
    @Size(min = 1, max = 20)
    private String name;
    @NotNull
    private Double height;
    @NotNull
    private Double weight;
    @NotNull
    @Size(min=5, max = 10, message = "El formato del codigo es de #0000")
    private String code;
    @NotBlank
    private String image;
    private List<EvolutionDto> evolutions;
    
    public PokemonDto() {
    }
    
    public PokemonDto(String name, Double height, Double weight, String code,String image, List<EvolutionDto> evolutions) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.code = code;
        this.image = image;
        this.evolutions = evolutions;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getImage() {
        return image;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<EvolutionDto> getEvolutions() {
        return evolutions;
    }
    public void setEvolutions(List<EvolutionDto> evolutions) {
        this.evolutions = evolutions;
    }

    
}
