package com.example.frostbyte_game_launcher.controllers;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.models.InstallGameDTO;
import com.example.frostbyte_game_launcher.repositories.AccountRepository;
import com.example.frostbyte_game_launcher.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.StoredProcedureParameter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    //Getting all the accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    //Adding a new account
    @PostMapping
    public ResponseEntity<Account> addNewAccount(@RequestBody Account account){
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    //Update account information
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Account>updateAccountInformation(@RequestBody Account account, @PathVariable Long id){
        Account accountToUpdate = accountService.getAccountById(id).get();
        accountToUpdate.setName(account.getName());
        accountToUpdate.setPassword(account.getPassword());
        accountToUpdate.setDateOfBirth(account.getDateOfBirth());
        accountToUpdate.setEmail(account.getEmail());

        accountRepository.save(accountToUpdate);
        return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
    }

    //Delete account
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteAccount(@PathVariable Long id){
        accountRepository.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.NO_CONTENT);

    }

    //Adding game to account
    @PutMapping(value = "/{id}")
    public ResponseEntity<Account> addGameToAccount(@RequestBody InstallGameDTO installGameDTO, @PathVariable long id){
        long gameId = installGameDTO.getGameId();
        Account updatedAccount = accountService.addGameToAccount(id, gameId);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    //Delete Game from Account - editing required
    @DeleteMapping(value = "/{accountId}/{gameId}")
    public ResponseEntity<Account> deleteGameFromAccount(@PathVariable Long accountId, @PathVariable Long gameId){
        Account accountToUpdate = accountService.getAccountById(accountId).get();
        List<Game> gameToDelete = accountToUpdate.getInstallGames();
        gameToDelete.remove(gameId);
        accountToUpdate.setInstallGames(gameToDelete);
        accountRepository.save(accountToUpdate);
        return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
    }
}
