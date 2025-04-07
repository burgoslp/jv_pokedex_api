package com.pokedex.pokedex.dtos.Pokemon;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreatePokemonDto {
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
    public CreatePokemonDto() {
    }
    public CreatePokemonDto(@NotBlank @Size(min = 1, max = 20) String name,
            @NotBlank @Size(min = 1, message = "debes agregar una descripción") String description,
            @NotNull Double height, @NotNull Double weight,
            @NotNull @Size(min = 5, max = 10, message = "El formato del codigo es de #0000") String code,
            @NotBlank String image) {
        this.name = name;
        this.description = description;
        this.height = height;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    
}
