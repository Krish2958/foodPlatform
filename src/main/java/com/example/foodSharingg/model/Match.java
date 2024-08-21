package com.example.foodSharingg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

import jakarta.persistence.*;

import jakarta.persistence.Table;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodGiverId;
    private Long foodTakerId;
    private String date;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodGiverId() {
        return foodGiverId;
    }

    public void setFoodGiverId(Long foodGiverId) {
        this.foodGiverId = foodGiverId;
    }

    public Long getFoodTakerId() {
        return foodTakerId;
    }

    public void setFoodTakerId(Long foodTakerId) {
        this.foodTakerId = foodTakerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}