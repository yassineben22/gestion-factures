package com.example.gestion.gestion_factures.controllers;

import com.example.gestion.gestion_factures.dto.DepenseAdd;
import com.example.gestion.gestion_factures.dto.DepenseDto;
import com.example.gestion.gestion_factures.services.implementation.DepenseServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json", consumes = "application/json")
public class DepenseController {

    @Autowired
    private DepenseServiceImp depenseServiceImp;

    @GetMapping(value = "/depenses")
    public ResponseEntity<List<DepenseDto>> getAll() {
        return ResponseEntity.ok(depenseServiceImp.getAll());
    }

    @GetMapping(value = "/depenses/{id}")
    public ResponseEntity<DepenseDto> get(@PathVariable Long id) {
        DepenseDto depenseDto = depenseServiceImp.get(id);
        if (depenseDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(depenseDto);
    }

    @PostMapping(value = "/depenses")
    public ResponseEntity<DepenseDto> add(@Valid @RequestBody DepenseAdd depenseDto) {
        DepenseDto result = depenseServiceImp.add(depenseDto);
        if (result == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/depenses/{id}")
    public ResponseEntity<DepenseDto> update(@PathVariable Long id, @Valid @RequestBody DepenseAdd depenseDto) {
        DepenseDto result = depenseServiceImp.update(id, depenseDto);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/depenses/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean result = depenseServiceImp.delete(id);
        if (!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
