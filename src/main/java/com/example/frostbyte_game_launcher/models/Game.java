package com.example.frostbyte_game_launcher.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "price")
    private Double price;

    @Column(name = "genre")
    private String genre;

    @Column(name = "age_rating")
    private String ageRating;

    @ManyToMany(mappedBy = "installGames")
    @JsonIgnoreProperties({"installGames"})
    private List<Account> players;

    public Game(){};

    public Game(String name, String publisher, Double price, String genre, String ageRating){
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
        this.ageRating = ageRating;
        this.players = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public List<Account> getPlayers() {
        return players;
    }

    public void setPlayers(List<Account> players) {
        this.players = players;
    }
}
