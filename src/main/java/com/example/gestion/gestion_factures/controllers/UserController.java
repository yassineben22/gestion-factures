package com.example.gestion.gestion_factures.controllers;

import com.example.gestion.gestion_factures.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json", consumes = "application/json")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/getUser", produces = "application/json")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getByToken(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token){
        return ResponseEntity.ok().body(userService.getUserByToken(token));
    }

}
