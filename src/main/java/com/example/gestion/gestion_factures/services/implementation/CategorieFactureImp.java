package com.example.gestion.gestion_factures.services.implementation;

import com.example.gestion.gestion_factures.dto.CategorieFactureAdd;
import com.example.gestion.gestion_factures.dto.CategorieFactureDto;
import com.example.gestion.gestion_factures.dtotomodel.CategorieFactureConvert;
import com.example.gestion.gestion_factures.models.CategorieFacture;
import com.example.gestion.gestion_factures.repositories.CategorieFactureRepository;
import com.example.gestion.gestion_factures.services.CategorieFactureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategorieFactureImp implements CategorieFactureService {

    @Autowired
    private CategorieFactureRepository categorieFactureRepository;
    @Override
    public CategorieFactureDto add(CategorieFactureAdd categorieFactureDto) {
        try {
            CategorieFacture categorieFacture = CategorieFactureConvert.addToModel(categorieFactureDto);
            categorieFactureRepository.save(categorieFacture);
            return CategorieFactureConvert.modelToDto(categorieFacture);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public CategorieFactureDto update(Long id, CategorieFactureAdd categorieFactureDto) {
        try {
            Optional<CategorieFacture> categorieFacture = categorieFactureRepository.findById(id);
            if (categorieFacture.isPresent()) {
                CategorieFacture categorieFacture1 = categorieFacture.get();
                categorieFacture1.setName(categorieFactureDto.getName());
                categorieFacture1.setDescription(categorieFactureDto.getDescription());
                categorieFactureRepository.save(categorieFacture1);
                return CategorieFactureConvert.modelToDto(categorieFacture1);
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            categorieFactureRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public CategorieFactureDto get(Long id) {
        try {
            Optional<CategorieFacture> categorieFacture = categorieFactureRepository.findById(id);
            if (categorieFacture.isPresent()) {
                return CategorieFactureConvert.modelToDto(categorieFacture.get());
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CategorieFactureDto> getAll() {
        return CategorieFactureConvert.modelToDto(categorieFactureRepository.findAll());
    }
}