package com.example.frostbyte_game_launcher.controllers;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }
}
