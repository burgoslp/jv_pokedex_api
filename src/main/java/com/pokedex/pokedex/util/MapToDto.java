package com.pokedex.pokedex.util;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MapToDto { 

    public <E, D> D mapToDto(E entity, Class<D> dtoClass) {
        if (entity == null){return null;}

        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();

            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
                throw new RuntimeException("Error al mapear entidad a DTO", e);
        }
    }
   
    public <E, D> List<D> mapListToDtoList(List<E> entities, Class<D> dtoClass) {
        List<D> dtoList = new ArrayList<>();
        if (entities != null) {
            for (E entity : entities) {
                dtoList.add(mapToDto(entity, dtoClass));
            }
        }
        return dtoList;
    }



}
