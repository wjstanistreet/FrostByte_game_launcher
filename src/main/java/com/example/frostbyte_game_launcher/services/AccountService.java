package com.example.frostbyte_game_launcher.services;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.repositories.AccountRepository;
import com.example.frostbyte_game_launcher.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GameRepository gameRepository;

    public void addGameToAccount(Game game, Account account){
        account.getInstallGames().add(game);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id){
        return accountRepository.findById(id);
    }

    public Account addGameToAccount(long accountId, long gameId){
        Account account = accountRepository.findById(accountId).get();
        Game game = gameRepository.findById(gameId).get();
        List<Game> gameList = account.getInstallGames();
        //if game is already in the account ^^^^^
        gameList.add(game);
        account.setInstallGames(gameList);
        accountRepository.save(account);
        return account;
    }

    public boolean checkEnoughMoney(long accountId, long gameId){
        double accountWallet = accountRepository.findById(accountId).get().getWallet();
        double gamePrice = gameRepository.findById(gameId).get().getPrice();
        return (accountWallet >= gamePrice);
    }

    public Account updateBalance(long accountId, long gameId){
        Account account = accountRepository.findById(accountId).get();
        double gamePrice = gameRepository.findById(gameId).get().getPrice();
        double currentWallet = account.getWallet();
        double updatedWallet = currentWallet - gamePrice;
        double roundedWallet = Math.round(updatedWallet * 100.0) / 100.0;
        account.setWallet(roundedWallet);
        accountRepository.save(account);
        return account;
    }

    public boolean checkGameInAccount(long accountId, long gameId){
        Account account = accountRepository.findById(accountId).get();
        List<Game> accountGames = account.getInstallGames();
        Game game = gameRepository.findById(gameId).get();
        return (accountGames.contains(game));
    }

    public boolean ageCheck(long accountId, long gameId){
        Account account = accountRepository.findById(accountId).get();
        int age = account.getYearByDOB();
        Game game = gameRepository.findById(gameId).get();
        int ratingAsInt = Integer.valueOf(game.getAgeRating());
        return(age >= ratingAsInt);
    }

}
