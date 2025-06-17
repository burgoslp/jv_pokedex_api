package com.pokedex.pokedex.dtos.Pokemon;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PokemonUpdateDto {
    @Size(min = 1, max = 20)
    private String name;
    @Column(length = 1000)
    @Size(min=1, message="debes agregar una descripción")   
    private String description;
    private Double height;
    private Double weight;
    @Size(min=5, max = 10, message = "El formato del codigo es de #0000")
    private String code;
    private String image;
}
