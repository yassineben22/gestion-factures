package com.example.gestion.gestion_factures.services;

import com.example.gestion.gestion_factures.dto.CategorieFactureAdd;
import com.example.gestion.gestion_factures.dto.CategorieFactureDto;
import com.example.gestion.gestion_factures.repositories.CategorieFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public interface CategorieFactureService {
    public CategorieFactureDto add(CategorieFactureAdd categorieFactureDto);

    public CategorieFactureDto update(Long id, CategorieFactureAdd categorieFactureDto);

    public boolean delete(Long id);

    public CategorieFactureDto get(Long id);

    public List<CategorieFactureDto> getAll();
}
