package com.example.gestion.gestion_factures.repositories;

import com.example.gestion.gestion_factures.models.CategorieFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieFactureRepository extends JpaRepository<CategorieFacture, Long> {
}
