package com.pokedex.pokedex.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.pokedex.pokedex.dtos.json.JsonApiresponse;
import com.pokedex.pokedex.services.interfaces.ITypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/pokedex")
public class TypeController {

    @Autowired
    private ITypeServices ts;

    @GetMapping("/type")
    public ResponseEntity<JsonApiresponse> findAll() {

        return ResponseEntity.ok().body(ts.findAll());
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<JsonApiresponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ts.findById(id));
    }
    
}
