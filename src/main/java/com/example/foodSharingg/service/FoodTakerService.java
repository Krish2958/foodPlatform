package com.example.foodSharingg.service;

import com.example.foodSharingg.model.FoodTaker;
import com.example.foodSharingg.repository.FoodTakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTakerService {

    @Autowired
    private FoodTakerRepository foodTakerRepository;

    public List<FoodTaker> getAllFoodTakers() {
        return foodTakerRepository.findAll();
    }

    public FoodTaker getFoodTakerById(Long id) {
        return foodTakerRepository.findById(id).orElse(null);
    }

    public FoodTaker createFoodTaker(FoodTaker foodTaker) {
        return foodTakerRepository.save(foodTaker);
    }

    public FoodTaker updateFoodTaker(Long id, FoodTaker foodTaker) {
        if (foodTakerRepository.existsById(id)) {
            foodTaker.setId(id); // Ensure the ID is set for update
            return foodTakerRepository.save(foodTaker);
        } else {
            return null;
        }
    }

    public void deleteFoodTaker(Long id) {
        foodTakerRepository.deleteById(id);
    }
}