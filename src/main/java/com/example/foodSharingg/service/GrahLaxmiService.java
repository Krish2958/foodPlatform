package com.example.foodSharingg.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.foodSharingg.repository.GrahLaxmiRepository;
import com.example.foodSharingg.model.GrahLaxmi;

import java.util.List;

import java.util.Optional; 

@Service
public class GrahLaxmiService {

    @Autowired
    private GrahLaxmiRepository grahLaxmiRepository;

    public GrahLaxmi updateGrahLaxmi(Long id, GrahLaxmi grahLaxmi) {
        Optional<GrahLaxmi> existingGrahLaxmi = grahLaxmiRepository.findById(id);
        if (existingGrahLaxmi.isPresent()) {
            GrahLaxmi updatedGrahLaxmi = existingGrahLaxmi.get();
            updatedGrahLaxmi.setName(grahLaxmi.getName());
            // Set other properties of GrahLaxmi as needed
            return grahLaxmiRepository.save(updatedGrahLaxmi);
        }
        return null;
    }

    public List<GrahLaxmi> getAllGrahLaxmis() {
        return grahLaxmiRepository.findAll();
    }

    // Other service methods here
}
