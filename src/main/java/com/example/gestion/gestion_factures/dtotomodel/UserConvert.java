package com.example.gestion.gestion_factures.dtotomodel;

import com.example.gestion.gestion_factures.dto.UserDto;
import com.example.gestion.gestion_factures.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserConvert {
    public static UserDto fromEntity(User user) {
        if (user == null) return null;
        final UserDto userDto = new UserDto();
        userDto.setId_user(user.getId_user());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        return userDto;
    }


    public static UserDto fromEntityWithoutStation(User user) {
        if (user == null) return null;
        final UserDto userDto = new UserDto();
        userDto.setId_user(user.getId_user());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) return null;
        final User user = new User();
        user.setId_user(userDto.getId_user());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public static UserDto fromEntityWithoutSubclasses(User user) {
        if (user == null) return null;
        final UserDto userDto = new UserDto();
        userDto.setId_user(user.getId_user());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        /*userDto.setPompes(PompeUserMapper.fromEntityList(user.getPompes()));*/
        return userDto;
    }

    public static User toEntityWithoutSubclasses(UserDto userDto) {
        if (userDto == null) return null;
        final User user = new User();
        user.setId_user(userDto.getId_user());
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        /*user.setPompes(PompeUserMapper.toEntityList(userDto.getPompes()));*/
        return user;
    }


    public static List<UserDto> fromEntityList(List<User> users) {
        if (users == null) return null;
        return users.stream().map(UserConvert::fromEntity).collect(Collectors.toList());
    }

    public static List<User> toEntityList(List<UserDto> userDtos) {
        if (userDtos == null) return null;
        return userDtos.stream().map(UserConvert::toEntity).collect(Collectors.toList());
    }


}