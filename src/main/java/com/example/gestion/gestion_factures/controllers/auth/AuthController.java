package com.example.gestion.gestion_factures.controllers.auth;

import com.example.gestion.gestion_factures.dto.AuthDto;
import com.example.gestion.gestion_factures.dto.LoginDto;
import com.example.gestion.gestion_factures.dto.RefreshTokenRequest;
import com.example.gestion.gestion_factures.services.implementation.AuthService;
import com.example.gestion.gestion_factures.util.PassEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PassEncode passEncode;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto){
        AuthDto dto = authService.login(loginDto);
        if (null == dto.getToken()){
            return ResponseEntity.status(400).body(dto);
        }else{
            return ResponseEntity.ok(dto);
        }
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AuthDto> register(){
        AuthDto dto = authService.register();
        if (null == dto.getToken()){
            return ResponseEntity.status(400).body(dto);
        }else{
            return ResponseEntity.ok(dto);
        }
    }

    @PostMapping(value = "/refresh", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest dto){
        return ResponseEntity.ok(authService.refreshToken(dto));
    }

    @PostMapping(value ="/logout", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> logout(@RequestBody RefreshTokenRequest dto){
        int i = authService.logout(dto);
        if (i == 0){
            return ResponseEntity.badRequest().body("logout_failed");
        }else{
            return ResponseEntity.ok().body("logout_success");
        }
    }




}
