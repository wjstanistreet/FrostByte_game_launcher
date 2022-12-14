package com.example.frostbyte_game_launcher.repositories;

import com.example.frostbyte_game_launcher.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByGenre(String genre);

    List<Game> findByAgeRating(String ageRating);

    List<Game> findByPrice(Double price);

    List<Game> findByName(String name);

    List<Game> findByPublisher(String publisher);
}
