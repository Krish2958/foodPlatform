
package com.example.foodSharingg.controller;

import com.example.foodSharingg.model.FoodTaker;
import com.example.foodSharingg.repository.FoodTakerRepository;
import com.example.foodSharingg.service.FoodTakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/food-takers")
public class FoodTakerController {

    @Autowired
    private FoodTakerService foodTakerService;

    @GetMapping
    public ResponseEntity<List<FoodTaker>> getAllFoodTakers() {
        List<FoodTaker> foodTakers = foodTakerService.getAllFoodTakers();
        return ResponseEntity.ok(foodTakers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodTaker> getFoodTakerById(@PathVariable Long id) {
        FoodTaker foodTaker = foodTakerService.getFoodTakerById(id);
        if (foodTaker != null) {
            return ResponseEntity.ok(foodTaker);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FoodTaker> createFoodTaker(@RequestBody FoodTaker foodTaker) {
        FoodTaker savedFoodTaker = foodTakerService.createFoodTaker(foodTaker);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFoodTaker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodTaker> updateFoodTaker(@PathVariable Long id, @RequestBody FoodTaker foodTaker) {
        FoodTaker updatedFoodTaker = foodTakerService.updateFoodTaker(id, foodTaker);
        if (updatedFoodTaker != null) {
            return ResponseEntity.ok(updatedFoodTaker);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodTaker(@PathVariable Long id) {
        foodTakerService.deleteFoodTaker(id);
        return ResponseEntity.noContent().build();
    }
}