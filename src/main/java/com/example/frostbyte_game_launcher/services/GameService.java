package com.example.frostbyte_game_launcher.services;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames(){
        return gameRepository.findAll();

    }

    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    }


