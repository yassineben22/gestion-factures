package com.example.gestion.gestion_factures.services;

import com.example.gestion.gestion_factures.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto getUserByToken(String token);
}
