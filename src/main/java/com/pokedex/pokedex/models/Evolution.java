package com.pokedex.pokedex.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="evolutions", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pokemon pokemon;
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
}
