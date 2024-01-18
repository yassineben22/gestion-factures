package com.example.gestion.gestion_factures.services.implementation;

import com.example.gestion.gestion_factures.advice.exceptions.EntityNotFoundException;
import com.example.gestion.gestion_factures.advice.exceptions.TokenRefreshException;
import com.example.gestion.gestion_factures.dto.AuthDto;
import com.example.gestion.gestion_factures.dto.LoginDto;
import com.example.gestion.gestion_factures.dto.RefreshTokenDto;
import com.example.gestion.gestion_factures.dto.RefreshTokenRequest;
import com.example.gestion.gestion_factures.dtotomodel.UserConvert;
import com.example.gestion.gestion_factures.models.RefreshToken;
import com.example.gestion.gestion_factures.models.User;
import com.example.gestion.gestion_factures.repositories.UserRepository;
import com.example.gestion.gestion_factures.services.RefreshTokenService;
import com.example.gestion.gestion_factures.util.PassEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PassEncode passEncode;
    @Autowired
    private RefreshTokenService refreshTokenService;

    public AuthDto login(LoginDto dto){
        final User user = userRepository.findByEmail(dto.getEmail()).orElse(null);
        if(null == user){
            throw new EntityNotFoundException("user_not_found");
        }
        if(!passEncode.matches(dto.getPassword(),user.getPassword())){
            return  new AuthDto(null,null, null, null);
        }else{
            final String jwtToken = jwtService.generateToken(UserDetails.class.cast(user));
            final RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
            return new AuthDto(jwtToken, "authentication_success", UserConvert.fromEntity(user), refreshToken.getToken());
        }
    }

    public AuthDto register(){
        User user = new User();
        user.setPassword(passEncode.encode("yassine123@"));
        user.setEmail("yassinebnlhbb@gmail.com");
        user.setNom("yassine");
        user.setPrenom("benlahbib");
        user = userRepository.save(user);
        final String jwtToken = jwtService.generateToken(user);
        final RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
        return new AuthDto(jwtToken, "authentication_success", UserConvert.fromEntity(user), refreshToken.getToken());
    }

    public RefreshTokenDto refreshToken(RefreshTokenRequest dto){
        String token = dto.getRefreshToken();
        return refreshTokenService.findByToken(token)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String jwtToken = jwtService.generateToken(user);
                    return new RefreshTokenDto(jwtToken, token);
                }).orElseThrow(() -> new TokenRefreshException("refresh_token_invalid"));
    }

    public int logout(RefreshTokenRequest dto) {
        RefreshToken token = refreshTokenService.findByToken(dto.getRefreshToken()).orElseThrow(() -> new TokenRefreshException("refresh_token_invalid"));
        return refreshTokenService.deleteByUserId(token.getUser().getId_user());
    }
}
