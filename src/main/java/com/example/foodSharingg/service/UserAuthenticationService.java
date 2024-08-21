package com.example.foodSharingg.service;

import com.example.foodSharingg.model.UserAuthentication;
import com.example.foodSharingg.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.foodSharingg.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserAuthenticationService {

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    public List<UserAuthentication> getAllUsers() {
        return userAuthenticationRepository.findAll();
    }

    public Optional<UserAuthentication> getUserById(Long id) {
        return userAuthenticationRepository.findById(id);
    }

    public UserAuthentication createUser(UserAuthentication user) {
        return userAuthenticationRepository.save(user);
    }

    public UserAuthentication updateUser(Long id, UserAuthentication userDetails) {
        UserAuthentication user = userAuthenticationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        return userAuthenticationRepository.save(user);
    }

    public void deleteUser(Long id) {
        UserAuthentication user = userAuthenticationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userAuthenticationRepository.delete(user);
    }

    public Optional<UserAuthentication> getUserByUsername(String username) {
        return userAuthenticationRepository.findByUsername(username);
    }
}
