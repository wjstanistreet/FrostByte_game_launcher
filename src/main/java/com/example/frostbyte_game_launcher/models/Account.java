package com.example.frostbyte_game_launcher.models;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private long id;
    private String name;
    private String password;
    private String dateOfBirth;
    private String email;
    private List<Game> installGames;

    public Account (){};

    public Account(String name, String password, String dateOfBirth, String email){
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.installGames = new ArrayList<>();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Game> getInstallGames() {
        return installGames;
    }

    public void setInstallGames(List<Game> installGames) {
        this.installGames = installGames;
    }
}
