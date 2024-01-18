package com.example.gestion.gestion_factures.dto;

import com.example.gestion.gestion_factures.models.Facture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepenseDto {

    private Long id;

    private String name;

    private String description;

    private double montant;

    FactureDto2 facture;

}
