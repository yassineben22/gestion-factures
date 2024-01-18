package com.example.gestion.gestion_factures.services.implementation;

import com.example.gestion.gestion_factures.advice.exceptions.EntityNotFoundException;
import com.example.gestion.gestion_factures.dto.UserDto;
import com.example.gestion.gestion_factures.dtotomodel.UserConvert;
import com.example.gestion.gestion_factures.models.User;
import com.example.gestion.gestion_factures.repositories.UserRepository;
import com.example.gestion.gestion_factures.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public UserDto getUserByToken(String token) {
        String jwt = token.substring(7);
        String userEmail = jwtService.extractEmail(jwt);
        Optional<User> result = userRepository.findByEmail(userEmail);
        return result.map(UserConvert::fromEntity).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
