package com.example.gestion.gestion_factures.dto;

import com.example.gestion.gestion_factures.models.Facture;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieFactureDto {

    private Long id;

    private String name;

    private String description;

    private List<FactureDto2> factures;
}
