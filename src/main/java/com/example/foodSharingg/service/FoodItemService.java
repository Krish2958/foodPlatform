package com.example.foodSharingg.service;

import com.example.foodSharingg.exception.ResourceNotFoundException;
import com.example.foodSharingg.model.FoodItem;
import com.example.foodSharingg.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(id);
        if (optionalFoodItem.isPresent()) {
            FoodItem existingFoodItem = optionalFoodItem.get();
            existingFoodItem.setName(foodItemDetails.getName());
            existingFoodItem.setQuantity(foodItemDetails.getQuantity());
            existingFoodItem.setEventType(foodItemDetails.getEventType());
            existingFoodItem.setLocation(foodItemDetails.getLocation());
            existingFoodItem.setDate(foodItemDetails.getDate());
            existingFoodItem.setEstimatedAttendees(foodItemDetails.getEstimatedAttendees());
            existingFoodItem.setFoodType(foodItemDetails.getFoodType());
            existingFoodItem.setNumberOfFoodItems(foodItemDetails.getNumberOfFoodItems());
            existingFoodItem.setNumberOfPersonsServed(foodItemDetails.getNumberOfPersonsServed());
            existingFoodItem.setExpirationDate(foodItemDetails.getExpirationDate());
            return foodItemRepository.save(existingFoodItem);
        } else {
            throw new ResourceNotFoundException("FoodItem not found with id " + id);
        }
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}

