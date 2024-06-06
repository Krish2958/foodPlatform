package com.example.foodSharingg.controller;

import com.example.foodSharingg.model.UserAuthentication;
import com.example.foodSharingg.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userss")
public class UserAuthenticationController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @GetMapping
    public List<UserAuthentication> getAllUsers() {
        return userAuthenticationService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAuthentication> getUserById(@PathVariable Long id) {
        Optional<UserAuthentication> user = userAuthenticationService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public UserAuthentication createUser(@RequestBody UserAuthentication user) {
        return userAuthenticationService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAuthentication> updateUser(@PathVariable Long id, @RequestBody UserAuthentication userDetails) {
        UserAuthentication updatedUser = userAuthenticationService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAuthenticationService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserAuthentication> getUserByUsername(@PathVariable String username) {
        Optional<UserAuthentication> user = userAuthenticationService.getUserByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
