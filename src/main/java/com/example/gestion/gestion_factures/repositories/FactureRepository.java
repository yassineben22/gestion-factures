package com.example.gestion.gestion_factures.repositories;

import com.example.gestion.gestion_factures.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
