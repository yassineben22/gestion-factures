package com.example.gestion.gestion_factures.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureAdd {

    private Date date;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Description is required")
    private String description;

    @Positive(message = "Montant must be positive")
    private double montant;

    private CategorieFactureAdd categorieFacture;

    private Long categorieId;
}
