package com.pokedex.pokedex.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.dtos.Evolution.CreateEvolutionDto;
import com.pokedex.pokedex.dtos.Evolution.EvolutionUpdateDto;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.exceptions.APIError;
import com.pokedex.pokedex.exceptions.APIException;
import com.pokedex.pokedex.models.Evolution;
import com.pokedex.pokedex.models.Pokemon;
import com.pokedex.pokedex.models.Type;
import com.pokedex.pokedex.repositories.IEvolutionRepository;
import com.pokedex.pokedex.repositories.IPokemonRepository;
import com.pokedex.pokedex.repositories.ITypeRepository;
import com.pokedex.pokedex.services.interfaces.IEvolutionServices;
import com.pokedex.pokedex.util.MapToDto;

@Service
public class EvolutionServices implements IEvolutionServices{

    @Autowired
    IEvolutionRepository er;

    @Autowired
    IPokemonRepository pr;

    @Autowired
    ITypeRepository tr;

    @Autowired
    private MapToDto map;

    @Override
    public JsonApiresponse findAll() {
      List<Evolution> evolutions= (List<Evolution>) er.findAll();
      return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.evolutionListToEvolutionSumaryDtoList(evolutions)).build();
    }

    @Override
    public JsonApiresponse findAllByOrderByWeightDesc() {
       List<Evolution> evolutions = er.findAllByOrderByWeightDesc();
       return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.evolutionListToEvolutionSumaryDtoList(evolutions)).build();

    }

    @Override
    public JsonApiresponse findAllByOrderByWeightAsc() {
        List<Evolution> evolutions=er.findAllByOrderByWeightAsc();
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.evolutionListToEvolutionSumaryDtoList(evolutions)).build();
    }
    

    @Override
    public JsonApiresponse findAllByOrderByHeightDesc() {
       List<Evolution> evolutions = er.findAllByOrderByHeightDesc();
       return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.evolutionListToEvolutionSumaryDtoList(evolutions)).build();
    }

    @Override
    public JsonApiresponse findAllByOrderByHeightAsc() {
        List<Evolution> evolutions = er.findAllByOrderByHeightAsc();
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.evolutionListToEvolutionSumaryDtoList(evolutions)).build();
    }

    @Override
    public JsonApiresponse findById(Long id) {
       Optional<Evolution> evolution= er.findById(id); 
       return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data( map.evolutionToEvolutionDetailsDto(evolution.orElseThrow(()->new APIException(APIError.EVOLUTION_BYID_NOT_FOUND)))).build();
    }

    @Override
    public JsonApiresponse  findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase(String name, String code) {
        List<Evolution> evolutions=er.findByNameLikeIgnoreCaseOrCodeLikeIgnoreCase("%"+name+"%","%"+code+"%");
        if (evolutions.isEmpty()) {
            throw new APIException(APIError.EVOLUTION_VALUE_NOT_FOUND);
        }
        return  JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.evolutionListToEvolutionSumaryDtoList(evolutions)).build();
    }

    @Override
    public JsonApiresponse save(CreateEvolutionDto createEvolutionDto) {
        Pokemon pokemon= pr.findById(createEvolutionDto.getPokemonId()).orElseThrow(() -> new APIException(APIError.POKEMON_BYID_NOT_FOUND));    
        
        Evolution evolution= Evolution.builder()
                                              .name(createEvolutionDto.getName())
                                              .description(createEvolutionDto.getDescription())
                                              .height(createEvolutionDto.getHeight())
                                              .weight(createEvolutionDto.getWeight())
                                              .code(createEvolutionDto.getCode())
                                              .image(createEvolutionDto.getImage())
                                              .pokemon(pokemon)
                                              .build();

        return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data(map.evolutionToEvolutionSumaryDto(er.save(evolution))).build();
    }

    @Override
    public JsonApiresponse update(Long id, EvolutionUpdateDto evolutionUpdateDTO) {
      Evolution evolution= er.findById(id).orElseThrow(()->new APIException(APIError.EVOLUTION_BYID_NOT_FOUND));
      
      evolution.setName(evolutionUpdateDTO.getName() != null ? evolutionUpdateDTO.getName() : evolution.getName());
      evolution.setDescription(evolutionUpdateDTO.getDescription() != null ? evolutionUpdateDTO.getDescription() : evolution.getDescription());
      evolution.setHeight(evolutionUpdateDTO.getHeight() != null ? evolutionUpdateDTO.getHeight() : evolution.getHeight());
      evolution.setWeight(evolutionUpdateDTO.getWeight() != null ? evolutionUpdateDTO.getWeight() : evolution.getWeight());
      evolution.setCode(evolutionUpdateDTO.getCode() != null ? evolutionUpdateDTO.getCode() : evolution.getCode());
      evolution.setImage(evolutionUpdateDTO.getImage() != null ? evolutionUpdateDTO.getImage() : evolution.getImage());

      return JsonApiresponse.builder().code(HttpStatus.CREATED.value()).message(HttpStatus.CREATED.getReasonPhrase()).data(map.evolutionToEvolutionSumaryDto(er.save(evolution))).build();
    }

    @Override
    public JsonApiresponse delete(Long id) {
        Evolution evolution= er.findById(id).orElseThrow(()-> new APIException(APIError.EVOLUTION_BYID_NOT_FOUND));
        er.delete(evolution);
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data("Se ha eliminado la evolución con exito.").build();
    }

    @Override
    public JsonApiresponse addType(Long evolutionId, List<Long> typeListId) {
        Evolution evolution= er.findById(evolutionId).orElseThrow(()-> new APIException(APIError.EVOLUTION_BYID_NOT_FOUND));
        if(typeListId ==null || typeListId.isEmpty()){
            throw new APIException(APIError.LIST_EMPTY);
        }
        List<Type> typeList= new ArrayList<>();
        typeListId.forEach(id ->{

            tr.findById(id).ifPresent(type ->{
                throw new APIException(APIError.TYPElIST_BYID_COINCIDENCE);
            });
            typeList.add(tr.findById(id).orElseThrow(()-> new APIException(APIError.TYPELIST_BYID_NOT_FOUND)));
        });
        evolution.getTypes().addAll(typeList);    
        er.save(evolution);
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data("Los tipos se han agregado correctamente").build();
    }

    @Override
    public JsonApiresponse addweakness(Long evolutionId, List<Long> weaknessListId) {
        Evolution evolution= er.findById(evolutionId).orElseThrow(()-> new APIException(APIError.EVOLUTION_BYID_NOT_FOUND));
        if(weaknessListId ==null || weaknessListId.isEmpty()){
            throw new APIException(APIError.LIST_EMPTY);
        }
        List<Type> weaknessList= new ArrayList<>();
        weaknessListId.forEach(id ->{

            tr.findById(id).ifPresent(type ->{
                throw new APIException(APIError.TYPElIST_BYID_COINCIDENCE);
            });
            weaknessList.add(tr.findById(id).orElseThrow(()-> new APIException(APIError.TYPELIST_BYID_NOT_FOUND)));
        });
        evolution.getTypes().addAll(weaknessList);    
        er.save(evolution);
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data("Los tipos se han agregado correctamente").build();
    }

}
