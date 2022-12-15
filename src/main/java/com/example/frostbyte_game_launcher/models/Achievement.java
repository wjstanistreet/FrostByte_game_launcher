package com.example.frostbyte_game_launcher.models;

public class Achievement {

    private String name;
    private String type;
    private Game game;

    public Achievement(){}

    public Achievement(String name, String type, Game game){
        this.name = name;
        this.type = type;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
