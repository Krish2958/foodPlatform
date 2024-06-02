package com.example.foodSharingg.controller;

import com.example.foodSharingg.model.FoodItem;
import com.example.foodSharingg.service.FoodItemService;

import com.example.foodSharingg.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping("/foodItems")
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/foodItems/{id}")
    public Optional<FoodItem> getFoodItemById(@PathVariable Long id) {
        return foodItemService.getFoodItemById(id);
    }

    @PostMapping("/foodItems")
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
        return foodItemService.createFoodItem(foodItem);
    }

    @PutMapping("/foodItems/{id}")
    public FoodItem updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItemDetails) {
        return foodItemService.updateFoodItem(id, foodItemDetails);
    }

    @DeleteMapping("/foodItems/{id}")
    public void deleteFoodItem(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
    }
}

