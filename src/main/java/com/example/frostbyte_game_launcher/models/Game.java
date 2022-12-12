package com.example.frostbyte_game_launcher.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private long id;
    private String name;
    private String publisher;
    private double price;
    private String genre;
    private String ageRating;
    private List<Account> players;

    public Game(){};

    public Game(String name, String publisher, double price, String genre, String ageRating){
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
