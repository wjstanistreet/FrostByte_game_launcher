package com.example.frostbyte_game_launcher.components;

import com.example.frostbyte_game_launcher.models.Account;
import com.example.frostbyte_game_launcher.models.Game;
import com.example.frostbyte_game_launcher.repositories.AccountRepository;
import com.example.frostbyte_game_launcher.repositories.GameRepository;
import com.example.frostbyte_game_launcher.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    AccountService accountService;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //Games Creation

        Game godOfWar = new Game("God Of War", "Corey Barlog", 30,
                "Fantasy", "18");
        gameRepository.save(godOfWar);

        Game persona5 = new Game("Persona 5", "Katsura Hashino", 20,
                "JRPG", "16");
        gameRepository.save(persona5);

        Game devilMayCry = new Game("Devil May Cry", "Hideaki Itsuno", 50,
                "Action", "18");
        gameRepository.save(devilMayCry);

        Game eldenRing = new Game("Elden ring", "Hidetaka Miyazaki",
                70,"Action", "18");
        gameRepository.save(eldenRing);

        Game forzaHorizon = new Game("Forza Horizon", "Bill Gates",
                68.99,"Racing", "3");
        gameRepository.save(forzaHorizon);

        Game marioKart = new Game("Mario Kart", "Shigeru Miyamoto",
                50,"Racing", "3");
        gameRepository.save(marioKart);


        //Account Creation
        Account accountOne = new Account("Will Stanistreet", "12345", "01/01/1992", "will@will.com" );
        accountRepository.save(accountOne);
        Account accountTwo = new Account("Shiyi Zhu", "88886", "08/08/1988", "shiyi@shiyi.com");
        accountRepository.save(accountTwo);
        Account accountThree = new Account("Eesaa Sheikh", "63729", "05/01/1996", "eesaa@eesaa.com");
        accountRepository.save(accountThree);
        Account accountFour = new Account("Fatimah Patel", "11111", "03/03/1993", "fatimah@fatimah.com");
        accountRepository.save(accountFour);

        //Adding games to accounts
        accountService.addGameToAccount(godOfWar, accountOne);
        accountService.addGameToAccount(godOfWar, accountFour);
        accountService.addGameToAccount(eldenRing, accountTwo);

        accountRepository.save(accountOne);
        accountRepository.save(accountFour);
        accountRepository.save(accountTwo);

    }

}
