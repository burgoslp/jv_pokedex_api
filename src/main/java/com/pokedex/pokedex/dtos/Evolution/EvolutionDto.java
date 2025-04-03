package com.pokedex.pokedex.dtos.Evolution;

public class EvolutionDto {
    private Long id;
    private String name;
    private Double height;
    private Double weight;
    private String code;
    private String image;
    public EvolutionDto() {

    }    
    public EvolutionDto(Long id, String name, Double height, Double weight,String code, String image) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.code=code;
        this.image = image;
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
