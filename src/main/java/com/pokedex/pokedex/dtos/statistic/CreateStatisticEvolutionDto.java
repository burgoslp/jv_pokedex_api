package com.pokedex.pokedex.dtos.statistic;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateStatisticEvolutionDto {
    @NotNull
    private Integer attack; 
    @NotNull
    private Integer defence; 
    @NotNull
    private Integer velocity;
    @NotNull
    private Integer life;
    @NotNull
    private Long evolutionId;
}
