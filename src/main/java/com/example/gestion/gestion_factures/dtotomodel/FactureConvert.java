package com.example.gestion.gestion_factures.dtotomodel;

import com.example.gestion.gestion_factures.dto.FactureAdd;
import com.example.gestion.gestion_factures.dto.FactureDto;
import com.example.gestion.gestion_factures.dto.FactureDto2;
import com.example.gestion.gestion_factures.models.Facture;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactureConvert {

        public static FactureDto modelToDto(Facture facture) {
            FactureDto factureDto = new FactureDto();
            factureDto.setId(facture.getId());
            factureDto.setDate(facture.getDate());
            factureDto.setTitle(facture.getTitle());
            factureDto.setDescription(facture.getDescription());
            factureDto.setMontant(facture.getMontant());
            factureDto.setCategorieFacture(CategorieFactureConvert.modeltoDto2(facture.getCategorieFacture()));
            factureDto.setDepenses(DepenseConvert.modelToDto2(facture.getDepenses()));
            return factureDto;
        }

        public static Facture addToModel(FactureAdd factureAdd) {
            Facture facture = new Facture();
            if(factureAdd.getDate() != null)
                facture.setDate(factureAdd.getDate());
            else
                facture.setDate(new Date(System.currentTimeMillis()));
            facture.setTitle(factureAdd.getTitle());
            facture.setDescription(factureAdd.getDescription());
            facture.setMontant(factureAdd.getMontant());
            if(factureAdd.getCategorieFacture() != null)
                facture.setCategorieFacture(CategorieFactureConvert.addToModel(factureAdd.getCategorieFacture()));
            facture.setDepenses(new ArrayList<>());
            return facture;
        }

        public static FactureDto2 modelToDto2(Facture facture) {
            FactureDto2 factureDto = new FactureDto2();
            factureDto.setId(facture.getId());
            factureDto.setDate(facture.getDate());
            factureDto.setTitle(facture.getTitle());
            factureDto.setDescription(facture.getDescription());
            factureDto.setMontant(facture.getMontant());
            return factureDto;
        }

        public static List<FactureDto2> modelToDto2(List<Facture> factures) {
            List<FactureDto2> factureDtos = new ArrayList<>();
            for (Facture facture : factures) {
                factureDtos.add(modelToDto2(facture));
            }
            return factureDtos;
        }

        public static List<FactureDto> modelToDto(List<Facture> factures) {
            List<FactureDto> factureDtos = new ArrayList<>();
            for (Facture facture : factures) {
                factureDtos.add(modelToDto(facture));
            }
            return factureDtos;
        }

}
