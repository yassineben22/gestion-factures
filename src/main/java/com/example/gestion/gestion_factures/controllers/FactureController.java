package com.example.gestion.gestion_factures.controllers;

import com.example.gestion.gestion_factures.dto.FactureAdd;
import com.example.gestion.gestion_factures.dto.FactureDto;
import com.example.gestion.gestion_factures.services.implementation.FactureServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json", consumes = "application/json")
public class FactureController {

    @Autowired
    private FactureServiceImp factureServiceImp;

    @GetMapping(value = "/factures")
    public ResponseEntity<List<FactureDto>> getAll() {
        return ResponseEntity.ok(factureServiceImp.getAll());
    }

    @GetMapping(value = "/factures/{id}")
    public ResponseEntity<FactureDto> get(@PathVariable Long id) {
        FactureDto factureDto = factureServiceImp.get(id);
        if (factureDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factureDto);
    }

    @PostMapping(value = "/factures")
    public ResponseEntity<FactureDto> add(@Valid @RequestBody FactureAdd factureDto) {
        FactureDto result = factureServiceImp.add(factureDto);
        if (result == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/factures/{id}")
    public ResponseEntity<FactureDto> update(@PathVariable Long id, @Valid @RequestBody FactureAdd factureDto) {
        FactureDto result = factureServiceImp.update(id, factureDto);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/factures/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean result = factureServiceImp.delete(id);
        if (!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
