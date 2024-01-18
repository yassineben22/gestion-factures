package com.example.gestion.gestion_factures.dtotomodel;

import com.example.gestion.gestion_factures.dto.DepenseAdd;
import com.example.gestion.gestion_factures.dto.DepenseDto;
import com.example.gestion.gestion_factures.dto.DepenseDto2;
import com.example.gestion.gestion_factures.models.Depense;

import java.util.List;

public class DepenseConvert {

    public static Depense addtoDepense(DepenseAdd depenseDto) {
        Depense depense = new Depense();
        depense.setName(depenseDto.getName());
        depense.setDescription(depenseDto.getDescription());
        depense.setMontant(depenseDto.getMontant());
        if(depense.getFacture() != null)
            depense.setFacture(FactureConvert.addToModel(depenseDto.getFacture()));

        return depense;
    }

    public static DepenseDto modelToDto(Depense depense) {
        DepenseDto depenseDto = new DepenseDto();
        depenseDto.setId(depense.getId());
        depenseDto.setName(depense.getName());
        depenseDto.setDescription(depense.getDescription());
        depenseDto.setMontant(depense.getMontant());
        depenseDto.setFacture(null);
        if(depense.getFacture() != null)
            depenseDto.setFacture(FactureConvert.modelToDto2(depense.getFacture()));
        return depenseDto;
    }

    public static DepenseDto2 modelToDto2(Depense depense) {
        DepenseDto2 depenseDto = new DepenseDto2();
        depenseDto.setId(depense.getId());
        depenseDto.setName(depense.getName());
        depenseDto.setDescription(depense.getDescription());
        depenseDto.setMontant(depense.getMontant());
        return depenseDto;
    }

    public static List<DepenseDto2> modelToDto2(List<Depense> depenses) {
        List<DepenseDto2> depenseDtos = new java.util.ArrayList<>();
        for (Depense depense : depenses) {
            depenseDtos.add(modelToDto2(depense));
        }
        return depenseDtos;
    }

    public static List<DepenseDto> modelToDto(List<Depense> depenses) {
        List<DepenseDto> depenseDtos = new java.util.ArrayList<>();
        for (Depense depense : depenses) {
            depenseDtos.add(modelToDto(depense));
        }
        return depenseDtos;
    }

    public static List<Depense> addtoDepense(List<DepenseAdd> depenseDtos) {
        List<Depense> depenses = new java.util.ArrayList<>();
        for (DepenseAdd depenseDto : depenseDtos) {
            depenses.add(addtoDepense(depenseDto));
        }
        return depenses;
    }
}
