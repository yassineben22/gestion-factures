package com.example.gestion.gestion_factures.services.implementation;

import com.example.gestion.gestion_factures.dto.*;
import com.example.gestion.gestion_factures.dtotomodel.CategorieFactureConvert;
import com.example.gestion.gestion_factures.dtotomodel.FactureConvert;
import com.example.gestion.gestion_factures.models.CategorieFacture;
import com.example.gestion.gestion_factures.models.Facture;
import com.example.gestion.gestion_factures.repositories.CategorieFactureRepository;
import com.example.gestion.gestion_factures.repositories.FactureRepository;
import com.example.gestion.gestion_factures.services.CategorieFactureService;
import com.example.gestion.gestion_factures.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImp implements FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private CategorieFactureRepository categorieFactureRepository;


    @Override
    public FactureDto add(FactureAdd factureDto) {
        try {
            Facture facture = FactureConvert.addToModel(factureDto);
            if(factureDto.getCategorieFacture() != null)
                facture.setCategorieFacture(CategorieFactureConvert.addToModel(factureDto.getCategorieFacture()));
            else if(factureDto.getCategorieId() != null) {
                Optional<CategorieFacture> categorieFacture = categorieFactureRepository.findById(factureDto.getCategorieId());
                if (categorieFacture.isPresent()) {
                    facture.setCategorieFacture(categorieFacture.get());
                }
            }
            else {
                facture.setCategorieFacture(categorieFactureRepository.findAll().get(0));
            }
            factureRepository.save(facture);
            return FactureConvert.modelToDto(facture);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public FactureDto update(Long id, FactureAdd factureDto) {
        try {
            Optional<Facture> facture = factureRepository.findById(id);
            if (facture.isPresent()) {
                Facture facture1 = facture.get();
                facture1.setDate(factureDto.getDate());
                facture1.setTitle(factureDto.getTitle());
                facture1.setDescription(factureDto.getDescription());
                facture1.setMontant(factureDto.getMontant());
                if(factureDto.getCategorieFacture() != null)
                    facture1.setCategorieFacture(CategorieFactureConvert.addToModel(factureDto.getCategorieFacture()));
                else if(factureDto.getCategorieId() != null) {
                    Optional<CategorieFacture> categorieFacture = categorieFactureRepository.findById(factureDto.getCategorieId());
                    if (categorieFacture.isPresent()) {
                        facture1.setCategorieFacture(categorieFacture.get());
                    }
                }
                factureRepository.save(facture1);
                return FactureConvert.modelToDto(facture1);
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
            factureRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public FactureDto get(Long id) {
        try {
            Optional<Facture> facture = factureRepository.findById(id);
            if (facture.isPresent()) {
                return FactureConvert.modelToDto(facture.get());
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<FactureDto> getAll() {
        return FactureConvert.modelToDto(factureRepository.findAll());
    }

}
