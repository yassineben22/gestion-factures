package com.example.gestion.gestion_factures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepenseDto2 {

    private Long id;

    private String name;

    private String description;

    private double montant;

}
