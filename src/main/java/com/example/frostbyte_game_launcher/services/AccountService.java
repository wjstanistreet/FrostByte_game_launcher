package com.example.frostbyte_game_launcher.services;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.repositories.AccountRepository;
import com.example.frostbyte_game_launcher.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Account addGameToAccount(Long accountId, Long gameId){
        Account account = accountRepository.findById(accountId).get();
        Game game = gameRepository.findById(gameId).get();
        List<Game> gameList = account.getInstallGames();
        //if game is already in the account ^^^^^
        gameList.add(game);
        account.setInstallGames(gameList);
        accountRepository.save(account);
        return account;
    }

}
