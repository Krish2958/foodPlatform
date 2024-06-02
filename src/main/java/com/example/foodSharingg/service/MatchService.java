package com.example.foodSharingg.service;

import com.example.foodSharingg.model.Match;
import com.example.foodSharingg.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.foodSharingg.exception.ResourceNotFoundException;


import java.util.List;
import java.util.Optional;


@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match matchDetails) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found for this id :: " + id));
        match.setFoodGiverId(matchDetails.getFoodGiverId());
        match.setFoodTakerId(matchDetails.getFoodTakerId());
        match.setDate(matchDetails.getDate());
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found for this id :: " + id));
        matchRepository.delete(match);
    }
}