package com.example.frostbyte_game_launcher.repositories;

import com.example.frostbyte_game_launcher.models.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

}
