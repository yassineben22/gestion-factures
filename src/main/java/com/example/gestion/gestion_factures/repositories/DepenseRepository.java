package com.example.gestion.gestion_factures.repositories;

import com.example.gestion.gestion_factures.models.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {
}
