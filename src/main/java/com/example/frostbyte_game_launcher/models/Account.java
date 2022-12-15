package com.example.frostbyte_game_launcher.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "wallet")
    private double wallet;

    //Friends Type list
    @ManyToMany
    @JsonIgnoreProperties({"friends", "installGames"})
    private Set<Account> friends = new HashSet<>();


    @ManyToMany
    @JoinTable (name = "accounts_games",
    joinColumns = @JoinColumn(name = "account_id"),
    inverseJoinColumns = @JoinColumn(name = "game_id"))
    @JsonIgnoreProperties({"players"})
    private List<Game> installGames;


    public Account (){}

    public Account(String name, String password, String dateOfBirth, String email){
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.installGames = new ArrayList<>();
        this.wallet = 0;
//        this.friendsList = new HashSet<Friendship>();
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

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public Set<Account> getFriends() {
        return friends;
    }

    public void setFriends(Set<Account> friends) {
        this.friends = friends;
    }

//    public void setFriends(Account friends) {
//        this.friends = friends;
//    }

    //convert String dateOfBirth to LocalDate DOB and return age in years;
    public int yearByDOB(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDOB = LocalDate.parse(this.dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(localDOB, currentDate).getYears();
    }
}
