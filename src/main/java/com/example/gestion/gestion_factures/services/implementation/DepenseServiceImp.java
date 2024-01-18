package com.example.gestion.gestion_factures.services.implementation;

import com.example.gestion.gestion_factures.dto.DepenseAdd;
import com.example.gestion.gestion_factures.dto.DepenseDto;
import com.example.gestion.gestion_factures.dtotomodel.DepenseConvert;
import com.example.gestion.gestion_factures.dtotomodel.FactureConvert;
import com.example.gestion.gestion_factures.models.Depense;
import com.example.gestion.gestion_factures.models.Facture;
import com.example.gestion.gestion_factures.repositories.DepenseRepository;
import com.example.gestion.gestion_factures.repositories.FactureRepository;
import com.example.gestion.gestion_factures.services.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepenseServiceImp implements DepenseService {

    @Autowired
    private DepenseRepository depenseRepository;

    @Autowired
    private FactureRepository factureRepository;

    @Override
    public DepenseDto get(Long id) {
        Optional<Depense> depense = depenseRepository.findById(id);
        if (depense.isPresent()) {
            return DepenseConvert.modelToDto(depense.get());
        }
        return null;
    }

    @Override
    public DepenseDto add(DepenseAdd depenseDto) {
        try {
            Depense depense = DepenseConvert.addtoDepense(depenseDto);
            if(depenseDto.getFactureId() != null) {
                Optional<Facture> facture = factureRepository.findById(depenseDto.getFactureId());
                if (facture.isPresent()) {
                    depense.setFacture(facture.get());
                }
            }
            depenseRepository.save(depense);
            return DepenseConvert.modelToDto(depense);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public DepenseDto update(Long id, DepenseAdd depenseDto) {
        try {
            Optional<Depense> depense = depenseRepository.findById(id);
            if (depense.isPresent()) {
                Depense depense1 = depense.get();
                depense1.setName(depenseDto.getName());
                depense1.setDescription(depenseDto.getDescription());
                depense1.setMontant(depenseDto.getMontant());
                if(depenseDto.getFacture() != null)
                    depense1.setFacture(FactureConvert.addToModel(depenseDto.getFacture()));
                else if(depenseDto.getFactureId() != null) {
                    Optional<Facture> facture = factureRepository.findById(depenseDto.getFactureId());
                    if (facture.isPresent()) {
                        depense1.setFacture(facture.get());
                    }
                }
                depenseRepository.save(depense1);
                return DepenseConvert.modelToDto(depense1);
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
            Optional<Depense> depense = depenseRepository.findById(id);
            if (depense.isPresent()) {
                depenseRepository.delete(depense.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<DepenseDto> getAll() {
        return DepenseConvert.modelToDto(depenseRepository.findAll());
    }
}
