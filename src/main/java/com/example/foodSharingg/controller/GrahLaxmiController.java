package com.example.foodSharingg.controller;

import com.example.foodSharingg.model.GrahLaxmi;
import com.example.foodSharingg.repository.GrahLaxmiRepository;
import com.example.foodSharingg.service.GrahLaxmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grah-laxmi")
public class GrahLaxmiController {

    @Autowired
    private GrahLaxmiRepository grahLaxmiRepository;

    @Autowired
    private GrahLaxmiService grahLaxmiService;

    @GetMapping("/")
    public List<GrahLaxmi> getAllGrahLaxmis() {
        return grahLaxmiRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrahLaxmi> getGrahLaxmiById(@PathVariable Long id) {
        Optional<GrahLaxmi> grahLaxmi = grahLaxmiRepository.findById(id);
        return grahLaxmi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public GrahLaxmi createGrahLaxmi(@RequestBody GrahLaxmi grahLaxmi) {
        return grahLaxmiRepository.save(grahLaxmi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrahLaxmi> updateGrahLaxmi(@PathVariable Long id, @RequestBody GrahLaxmi grahLaxmiDetails) {
        Optional<GrahLaxmi> grahLaxmiOptional = grahLaxmiRepository.findById(id);
        if (!grahLaxmiOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        GrahLaxmi grahLaxmi = grahLaxmiOptional.get();
        grahLaxmi.setAccountNumber(grahLaxmiDetails.getAccountNumber());
        grahLaxmi.setName(grahLaxmiDetails.getName());
        grahLaxmi.setCity(grahLaxmiDetails.getCity());
        grahLaxmi.setAadharNumber(grahLaxmiDetails.getAadharNumber());
        GrahLaxmi updatedGrahLaxmi = grahLaxmiRepository.save(grahLaxmi);
        return ResponseEntity.ok(updatedGrahLaxmi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrahLaxmi(@PathVariable Long id) {
        Optional<GrahLaxmi> grahLaxmi = grahLaxmiRepository.findById(id);
        if (!grahLaxmi.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        grahLaxmiRepository.delete(grahLaxmi.get());
        return ResponseEntity.noContent().build();
    }
}


