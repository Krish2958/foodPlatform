package com.example.foodSharingg.repository;

import com.example.foodSharingg.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    // Additional query methods can be defined here
}