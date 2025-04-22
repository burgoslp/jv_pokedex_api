package com.pokedex.pokedex.dtos.type;
import jakarta.validation.constraints.NotBlank;

public class CreateTypeDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
