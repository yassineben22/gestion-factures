package com.example.gestion.gestion_factures.dtotomodel;

import com.example.gestion.gestion_factures.dto.CategorieFactureDto;
import com.example.gestion.gestion_factures.dto.CategorieFactureAdd;
import com.example.gestion.gestion_factures.dto.CategorieFactureDto2;
import com.example.gestion.gestion_factures.models.CategorieFacture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategorieFactureConvert {

    public static CategorieFactureDto modelToDto(CategorieFacture categorieFacture) {
        CategorieFactureDto categorieFactureDto = new CategorieFactureDto();
        categorieFactureDto.setId(categorieFacture.getId());
        categorieFactureDto.setName(categorieFacture.getName());
        categorieFactureDto.setDescription(categorieFacture.getDescription());
        categorieFactureDto.setFactures(FactureConvert.modelToDto2(categorieFacture.getFactures()));
        return categorieFactureDto;
    }

    public static CategorieFactureDto2 modeltoDto2(CategorieFacture categorieFacture) {
        CategorieFactureDto2 categorieFactureDto = new CategorieFactureDto2();
        categorieFactureDto.setId(categorieFacture.getId());
        categorieFactureDto.setName(categorieFacture.getName());
        categorieFactureDto.setDescription(categorieFacture.getDescription());
        return categorieFactureDto;
    }

    public static CategorieFacture addToModel(CategorieFactureAdd categorieFactureAdd) {
        CategorieFacture categorieFacture = new CategorieFacture();
        categorieFacture.setName(categorieFactureAdd.getName());
        categorieFacture.setDescription(categorieFactureAdd.getDescription());
        categorieFacture.setFactures(new ArrayList<>());
        return categorieFacture;
    }

    public static List<CategorieFactureDto> modelToDto(List<CategorieFacture> categorieFactures) {
        List<CategorieFactureDto> categorieFactureDtos = new ArrayList<>();
        for (CategorieFacture categorieFacture : categorieFactures) {
            categorieFactureDtos.add(modelToDto(categorieFacture));
        }
        return categorieFactureDtos;
    }

}
