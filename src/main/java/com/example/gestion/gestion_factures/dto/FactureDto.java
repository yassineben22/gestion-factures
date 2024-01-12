package com.example.gestion.gestion_factures.dto;

import com.example.gestion.gestion_factures.models.CategorieFacture;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {

    private Long id;

    private Date date;

    private String title;

    private String description;

    private double montant;

    private CategorieFactureDto2 categorieFacture;
}
