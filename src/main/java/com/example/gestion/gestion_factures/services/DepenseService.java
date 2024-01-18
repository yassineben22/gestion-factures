package com.example.gestion.gestion_factures.services;

import com.example.gestion.gestion_factures.dto.DepenseAdd;
import com.example.gestion.gestion_factures.dto.DepenseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepenseService {

    public DepenseDto get(Long id);

    public DepenseDto add(DepenseAdd depenseDto);

    public DepenseDto update(Long id, DepenseAdd depenseDto);

    public boolean delete(Long id);

    public List<DepenseDto> getAll();

}
