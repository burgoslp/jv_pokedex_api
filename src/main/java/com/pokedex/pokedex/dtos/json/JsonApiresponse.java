package com.pokedex.pokedex.dtos.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JsonApiresponse {
    private Integer code;
    private String message;
    private Object data;
}
