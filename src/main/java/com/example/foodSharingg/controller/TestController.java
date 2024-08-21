package com.example.foodSharingg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.foodSharingg.model.FoodGiver;
import com.example.foodSharingg.repository.FoodGiverRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodSharingg.service.FoodGiverService;

@RestController
public class TestController {

    @Autowired
    private FoodGiverRepository foodGiverRepository;

     @Autowired
    private FoodGiverService foodGiverService;

    @GetMapping("/test")
    public String test() {
        FoodGiver foodGiver = new FoodGiver();
        foodGiver.setEventType("Charity Event");
        foodGiver.setLocation("Community Hall");
        foodGiver.setDate("2023-06-15");
        foodGiver.setEstimatedAttendees(100);
        foodGiver.setFoodType("Veg");
        foodGiver.setNumberOfFoodItems(10);
        foodGiver.setNumberOfPersonsServed(50);
        foodGiverRepository.save(foodGiver);
        return "FoodGiver saved successfully!";
    }
}

