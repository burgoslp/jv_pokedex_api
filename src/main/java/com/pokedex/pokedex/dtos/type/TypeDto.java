package com.pokedex.pokedex.dtos.type;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TypeDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
