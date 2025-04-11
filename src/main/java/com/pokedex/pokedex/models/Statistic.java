package com.pokedex.pokedex.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="statistics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pokemon_id",referencedColumnName = "id")
    private Pokemon pokemon;
    @OneToOne
    @JoinColumn(name = "evolution_id",referencedColumnName = "id")
    private Evolution evolution;
    @NotNull
    private Integer attack; 
    @NotNull
    private Integer defence; 
    @NotNull
    private Integer velocity;
    @NotNull
    private Integer life;
}
