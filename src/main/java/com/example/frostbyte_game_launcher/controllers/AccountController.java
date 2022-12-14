package com.example.frostbyte_game_launcher.controllers;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.models.InstallGameDTO;
import com.example.frostbyte_game_launcher.models.Reply;
import com.example.frostbyte_game_launcher.repositories.AccountRepository;
import com.example.frostbyte_game_launcher.repositories.GameRepository;
import com.example.frostbyte_game_launcher.services.AccountService;
import com.example.frostbyte_game_launcher.services.GameService;
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

    @Autowired
    GameService gameService;
    @Autowired
    private GameRepository gameRepository;

    //Getting all the accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> getAccountByID(@PathVariable long id){
        Optional<Account> account1 = accountService.getAccountById(id);
        if (account1.isPresent()){
            return new ResponseEntity<>(account1.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<Reply> addGameToAccount(@RequestBody InstallGameDTO installGameDTO, @PathVariable long id){
        long gameId = installGameDTO.getGameId();
        Account account = accountRepository.findById(id).get();
        if(!accountService.ageCheck(id, gameId)){
            Reply reply = new Reply("You're not permitted to buy the game at this time.", account);
            return new ResponseEntity<>(reply, HttpStatus.FORBIDDEN);
        }
        if (accountService.checkGameInAccount(id, gameId)){
            Reply reply = new Reply("Game already in account", account);
            return new ResponseEntity<>(reply, HttpStatus.FORBIDDEN);
        }
        if (accountService.checkEnoughMoney(id, gameId)){
            Account updatedAccount = accountService.addGameToAccount(id, gameId);
            updatedAccount = accountService.updateBalance(id, gameId);
            Reply reply = new Reply("Purchase successful: Enjoy the game!", updatedAccount);
            return new ResponseEntity<>(reply, HttpStatus.OK);
        } else {
            Reply reply = new Reply("Transaction failed: Insufficient funds", account);
            return new ResponseEntity<>(reply, HttpStatus.FORBIDDEN);
        }
    }

    //Delete Game from Account - editing required
    @DeleteMapping(value = "/{accountId}/{gameId}")
    public ResponseEntity<Account> deleteGameFromAccount(@PathVariable Long accountId, @PathVariable Long gameId){
        Account accountToUpdate = accountService.getAccountById(accountId).get();
        Game game = gameService.getGameById(gameId).get();
        List<Game> gameToDelete = accountToUpdate.getInstallGames();
        gameToDelete.remove(game);
        accountToUpdate.setInstallGames(gameToDelete);
        accountRepository.save(accountToUpdate);
        return new ResponseEntity<>(accountToUpdate, HttpStatus.NOT_FOUND);
    }
}
