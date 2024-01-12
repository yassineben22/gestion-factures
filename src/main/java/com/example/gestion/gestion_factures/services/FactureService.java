package com.example.gestion.gestion_factures.services;

import com.example.gestion.gestion_factures.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {

    public FactureDto add(FactureAdd factureDto);

    public FactureDto update(Long id, FactureAdd factureDto);

    public boolean delete(Long id);

    public FactureDto get(Long id);

    public List<FactureDto> getAll();


}
