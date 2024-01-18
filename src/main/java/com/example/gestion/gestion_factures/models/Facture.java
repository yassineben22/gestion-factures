package com.example.gestion.gestion_factures.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String title;

    private String description;

    private double montant;

    @ManyToOne(optional = false)
    private CategorieFacture categorieFacture;

    @OneToMany(mappedBy = "facture", orphanRemoval = true)
    @Cascade(CascadeType.DELETE_ORPHAN)
    private List<Depense> depenses;

}
