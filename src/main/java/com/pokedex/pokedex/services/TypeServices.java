package com.pokedex.pokedex.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.exceptions.APIError;
import com.pokedex.pokedex.exceptions.APIException;
import com.pokedex.pokedex.models.Type;
import com.pokedex.pokedex.repositories.ITypeRepository;
import com.pokedex.pokedex.services.interfaces.ITypeServices;
import com.pokedex.pokedex.util.MapToDto;

@Service
public class TypeServices implements ITypeServices{
    @Autowired
    private ITypeRepository tr;
    
    @Autowired
    private MapToDto map;

    @Override
    public JsonApiresponse findAll() {
        List<Type> typeList=(List<Type>)tr.findAll();
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.typeToDtoList(typeList)).build();
    }

    @Override
    public JsonApiresponse findById(Long id) {
        Type type = tr.findById(id).orElseThrow(() -> new APIException(APIError.TYPE_BYID_NOT_FOUND));        
        return JsonApiresponse.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(map.typeToDto(type)).build();
    }

    



}
