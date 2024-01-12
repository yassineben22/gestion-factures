package com.example.gestion.gestion_factures.controllers;

import com.example.gestion.gestion_factures.dto.CategorieFactureAdd;
import com.example.gestion.gestion_factures.dto.CategorieFactureDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestion.gestion_factures.services.implementation.CategorieFactureImp;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json", consumes = "application/json")
public class CategorieFactureController {


    @Autowired
    private CategorieFactureImp categorieFactureImp;

    @GetMapping("/categories")
    public ResponseEntity<List<CategorieFactureDto>> getAll() {
        return ResponseEntity.ok(categorieFactureImp.getAll());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategorieFactureDto> get(@PathVariable Long id) {
        CategorieFactureDto categorieFactureDto = categorieFactureImp.get(id);
        if (categorieFactureDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categorieFactureDto);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategorieFactureDto> add(@Valid @RequestBody CategorieFactureAdd categorieFactureDto) {
       CategorieFactureDto result = categorieFactureImp.add(categorieFactureDto);
         if (result == null) {
              return ResponseEntity.badRequest().body(null);
         }
            return ResponseEntity.ok(result);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategorieFactureDto> update(@PathVariable Long id, @Valid @RequestBody CategorieFactureAdd categorieFactureDto) {
        CategorieFactureDto result = categorieFactureImp.update(id, categorieFactureDto);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean result = categorieFactureImp.delete(id);
        if (!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
