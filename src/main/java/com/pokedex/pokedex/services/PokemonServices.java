package com.pokedex.pokedex.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.repositories.IPokemonRepository;
import com.pokedex.pokedex.services.interfaces.IPokemonServices;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;
import dtos.Evolution.EvolutionDto;
import dtos.Pokemon.PokemonDto;

@Service
public class PokemonServices implements IPokemonServices {

    @Autowired
    IPokemonRepository pr;
    
    @Override
    public List<PokemonDto> findAll() {
       
        Iterable<Pokemon> pokemons =pr.findAll();
        List<PokemonDto> pokemonDtos= new ArrayList<>();

        pokemons.forEach(poke ->{
            pokemonDtos.add(pokemonToDto(poke));
        });
        
        return pokemonDtos;
    }

    @Override
    public List<PokemonDto> findAllByOrderByWeightDesc() {
       List<Pokemon> pokemons = pr.findAllByOrderByWeightDesc();

       List<PokemonDto> pokemonDtos= new ArrayList<>();

       pokemons.forEach(poke ->{
           pokemonDtos.add(pokemonToDto(poke));
       });
       
       return pokemonDtos;
    }

    @Override
    public List<PokemonDto> findAllByOrderByWeightAsc() {
        List<Pokemon> pokemons=pr.findAllByOrderByWeightAsc();
        List<PokemonDto> pokemonDtos= new ArrayList<>();

        pokemons.forEach(poke ->{
            pokemonDtos.add(pokemonToDto(poke));
        });

        return pokemonDtos;
    }
    

    @Override
    public List<PokemonDto> findAllByOrderByHeightDesc() {
        List<Pokemon> pokemons = pr.findAllByOrderByHeightDesc();

       List<PokemonDto> pokemonDtos= new ArrayList<>();

       pokemons.forEach(poke ->{
           pokemonDtos.add(pokemonToDto(poke));
       });
       
       return pokemonDtos;
    }

    @Override
    public List<PokemonDto> findAllByOrderByHeightAsc() {
        List<Pokemon> pokemons = pr.findAllByOrderByHeightAsc();

       List<PokemonDto> pokemonDtos= new ArrayList<>();

       pokemons.forEach(poke ->{
           pokemonDtos.add(pokemonToDto(poke));
       });
       
       return pokemonDtos;
    }

    @Override
    public Optional<PokemonDto> findById(Long id)  throws Exception {
        Optional<Pokemon> pokemon= pr.findById(id);     

       return Optional.ofNullable(pokemonToDto(pokemon.orElseThrow()));
    }

    @Override
    public List<PokemonDto>  findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code) {
        
        List<Pokemon> pokemons=pr.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase("%"+name+"%","%"+code+"%");
        List<PokemonDto> pokemonsDto= new ArrayList<>();
        pokemons.forEach(poke->{
            pokemonsDto.add(pokemonToDto(poke));
        });
        return pokemonsDto;
    }

    

    @Override
    public PokemonDto save(PokemonDto pokemonDto) {

        Pokemon pokemon= new Pokemon(pokemonDto.getName(),pokemonDto.getHeight(),pokemonDto.getHeight(),pokemonDto.getCode(),pokemonDto.getImage());
        return pokemonToDto(pr.save(pokemon));
    }

    @Override
    public PokemonDto update(Long id, PokemonDto pokemonDto) {
       Optional<Pokemon> originalPokemon= pr.findById(id);
       Pokemon updatePokemon=originalPokemon.map(poke ->{
            Pokemon pokemon = poke;
            pokemon.setName(pokemonDto.getName());
            pokemon.setHeight(pokemonDto.getHeight());
            pokemon.setWeight(pokemonDto.getWeight());
            pokemon.setCode(pokemonDto.getCode());
            pokemon.setImage(pokemonDto.getImage());
            return pr.save(pokemon);
       }).orElseThrow();

       return pokemonToDto(updatePokemon);
    }

    @Override
    public  Optional<Pokemon> delete(Long id) {
        Optional<Pokemon> pokemonOptional= pr.findById(id);
        pokemonOptional.ifPresent(evolution -> {
            pr.delete(evolution);
        });
        return pokemonOptional;
    }


    private PokemonDto pokemonToDto(Pokemon pokemon){

        PokemonDto pokemonDto= new PokemonDto();
        //intanciar lista de evolucionDto para agregar a nuesto pokemonDto todas las evoluciones del modelo pokemon
        List<EvolutionDto> evolutionDtos= new ArrayList<>();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setHeight(pokemon.getHeight());
        pokemonDto.setWeight(pokemon.getWeight());
        pokemonDto.setCode(pokemon.getCode());
        pokemonDto.setImage(pokemon.getImage());

        //recorremos las evoluciones del modelo pokemon para setearlas a una instancia evolutioDto
        if(pokemon.getEvolutions() != null){
            for (Evolution evolution : pokemon.getEvolutions()) {          

                evolutionDtos.add(EvolutionToDto(evolution));
            }
            pokemonDto.setEvolutions(evolutionDtos);
       }
        return pokemonDto;
    }

    private EvolutionDto EvolutionToDto(Evolution evolution){

        EvolutionDto evolutionDto = new EvolutionDto();   

        evolutionDto.setId(evolution.getId());
        evolutionDto.setName(evolution.getName());
        evolutionDto.setHeight(evolution.getHeight());
        evolutionDto.setWeight(evolution.getWeight());
        evolutionDto.setCode(evolution.getCode());
        evolutionDto.setImage(evolution.getImage());

        return evolutionDto;
    }

   
   
}
