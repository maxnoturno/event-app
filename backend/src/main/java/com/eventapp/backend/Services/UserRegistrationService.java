package com.eventapp.backend.Services;

import com.eventapp.backend.Model.User;
import com.eventapp.backend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User registrate(User user){
        user.setToken(tokenService.generateToken(user));
        return userRepository.save(user);
    }
    public User update(User user){
        user.setToken(tokenService.generateToken(user));
        return userRepository.save(user);
    }

}