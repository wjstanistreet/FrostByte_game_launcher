package com.example.frostbyte_game_launcher.controllers;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.services.AccountService;
import com.example.frostbyte_game_launcher.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> allGames = gameService.getAllGames();
        return new ResponseEntity<>(allGames, HttpStatus.OK);
    }
}
