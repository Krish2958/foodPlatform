package com.example.foodSharingg.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.foodSharingg.model.FoodGiver;
import com.example.foodSharingg.repository.FoodGiverRepository;

import java.util.List;

@Service
public class FoodGiverService {
    @Autowired
    private FoodGiverRepository foodGiverRepository;

    public List<FoodGiver> getAllFoodGivers() {
        return foodGiverRepository.findAll();
    }
}

