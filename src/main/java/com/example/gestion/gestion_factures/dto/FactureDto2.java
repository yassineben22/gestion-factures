package com.example.gestion.gestion_factures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto2 {

    private Long id;

    private Date date;

    private String title;

    private String description;

    private double montant;
}
