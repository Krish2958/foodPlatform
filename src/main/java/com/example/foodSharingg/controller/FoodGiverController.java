package com.example.foodSharingg.controller;

import com.example.foodSharingg.model.FoodGiver;

import com.example.foodSharingg.repository.FoodGiverRepository;
import com.example.foodSharingg.service.FoodGiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-givers/")
public class FoodGiverController {


    @Autowired
    private FoodGiverService foodGiverService;

    @Autowired
    private FoodGiverRepository foodGiverRepository;

    @GetMapping
    public ResponseEntity<List<FoodGiver>> getAllFoodGivers() {
        List<FoodGiver> foodGivers = foodGiverRepository.findAll();
        return ResponseEntity.ok(foodGivers);
    }

    @PostMapping
    public ResponseEntity<FoodGiver> submitFood(@RequestBody FoodGiver foodGiver) {
        FoodGiver savedFoodGiver = foodGiverRepository.save(foodGiver);
        return ResponseEntity.status(201).body(savedFoodGiver);
    }
}
