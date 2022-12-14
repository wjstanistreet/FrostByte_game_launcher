package com.example.frostbyte_game_launcher.controllers;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.repositories.GameRepository;
import com.example.frostbyte_game_launcher.services.AccountService;
import com.example.frostbyte_game_launcher.services.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    GameRepository gameRepository;

    //Getting games with filters for genre, ageRating and price
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(@RequestParam(required = false,name = "genre")String genre,
                                                  @RequestParam (required = false,name = "ageRating")String ageRating,
                                                  @RequestParam(required = false, name = "price") double price){
        List<Game> allGames = gameService.getAllGames();
         if(genre != null){return new ResponseEntity<>(gameRepository.findByGenre(genre),HttpStatus.OK);}

         if (ageRating != null){return new ResponseEntity<>(gameRepository.findByAgeRating(ageRating),HttpStatus.OK);}

         if (price != 0){return new ResponseEntity<>(gameRepository.findByPrice(price), HttpStatus.OK);}

         else {
             // TODO: Ignore list of players when showing All Games
             return new ResponseEntity<>(allGames, HttpStatus.OK);
         }
    }

    //Get games by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity <Game> getGameById(@PathVariable Long id){
        Optional<Game> game = gameService.getGameById(id);
        if (game.isPresent()){
            return new ResponseEntity<>(game.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
