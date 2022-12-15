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

import java.util.HashSet;

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
        // Genre including :
        // Action
        // Fantasy
        // Racing
        // Sport
        // JRPG
        //Stealth
        //RTS
        // Open World

        Game godOfWar = new Game("God Of War", "Corey Barlog", 30.0,
                "Fantasy", "18");
        gameRepository.save(godOfWar);

        Game persona5 = new Game("Persona 5", "Katsura Hashino", 20.0,
                "JRPG", "16");
        gameRepository.save(persona5);

        Game devilMayCry = new Game("Devil May Cry", "Hideaki Itsuno", 50.0,
                "Action", "18");
        gameRepository.save(devilMayCry);

        Game eldenRing = new Game("Elden ring", "Hidetaka Miyazaki",
                70.0,"Action", "18");
        gameRepository.save(eldenRing);

        Game forzaHorizon = new Game("Forza Horizon", "Bill Gates",
                68.99,"Racing", "3");
        gameRepository.save(forzaHorizon);

        Game marioKart = new Game("Mario Kart", "Shigeru Miyamoto",
                50.0,"Racing", "3");
        gameRepository.save(marioKart);

        Game horizonZeroDawn = new Game("Horizon Zero Dawn", "Mathijs de Jonge", 79.99,
                "Fantasy", "16");
        gameRepository.save(horizonZeroDawn);

        Game persona3 = new Game("Persona 3", "Katsura Hashino", 20.0,
                "JRPG", "16");
        gameRepository.save(persona3);

        Game persona = new Game("Persona", "Hideaki Itsuno", 5.0,
                "JRPG", "15");
        gameRepository.save(persona);

        Game darkSouls = new Game("dark Souls", "Hidetaka Miyazaki",
                15.0,"Action", "18");
        gameRepository.save(darkSouls);

        Game darkSouls2 = new Game("dark Souls2", "Hidetaka Miyazaki",
                20.0,"Action", "18");
        gameRepository.save(darkSouls2);

        Game darkSouls3 = new Game("dark Souls 3", "Hidetaka Miyazaki",
                15.0,"Action", "18");
        gameRepository.save(darkSouls3);

        Game bloodBourne = new Game("BloodBourne", "Hidetaka Miyazaki",
                70.0,"Action", "18");
        gameRepository.save(bloodBourne);

        Game f1 = new Game("F1 Championships", "Lewis Hamilton",
                1.0,"Racing", "3");
        gameRepository.save(f1);

        Game midnightClub = new Game("Midnight club", "Jeff Pidasdny",
                29.94,"Racing", "3");
        gameRepository.save(midnightClub);

        Game godOfWarRagnorok = new Game("God Of War Ragnorok", "Corey Barlog", 70.0,
                "Fantasy", "18");
        gameRepository.save(godOfWarRagnorok);

        Game persona4Golden= new Game("Persona 4 Golden", "Katsura Hashino", 24.99,
                "JRPG", "16");
        gameRepository.save(persona4Golden);

        Game gtaSanAndreas = new Game("Grand Theft Auto San Andreas", "Leslie Benzies", 21.99,
                "Open World", "18");
        gameRepository.save(gtaSanAndreas);

        Game gtaV = new Game("Grand Theft Auto V", "Leslie Benzies",
                49.99,"Open World", "18");
        gameRepository.save(gtaV);

        Game gtaViceCity = new Game("Grand Theft Auto Vice City", "Leslie Benzies",
                10.0,"Open World", "18");
        gameRepository.save(gtaViceCity);

        Game spidermanPS4 = new Game("SpiderMan ps4", "Bryan Intihar",
                64.99,"Open World", "16");
        gameRepository.save(spidermanPS4);

        Game dragonQuest14 = new Game("Dragon Quest 14", "Naoki Yoshid", 59.99,
                "Open World", "16");
        gameRepository.save(dragonQuest14);

        Game smtV = new Game("Shin Megami Tensai", "Kazuma Kaneko", 20.0,
                "JRPG", "16");
        gameRepository.save(smtV);

        Game fifa15 = new Game("Fifa 15", "Penaldo", 5.0,
                "Sport", "3");
        gameRepository.save(fifa15);

        Game fifa05 = new Game("Fifa 05", "Penaldo",
                27.99,"Sport", "3");
        gameRepository.save(fifa05);

        Game madden22 = new Game("Madden 22", "Katy Livingston",
                69.99,"Sport", "3");
        gameRepository.save(madden22);

        Game nba2K22 = new Game("NBA 2K22", "Katy Livingston",
                32.99,"Sport", "3");
        gameRepository.save(darkSouls3);

        Game streetFighter5 = new Game("Street Fighter 5", "Takayuki Nakayama",
                20.0,"Fighting", "12");
        gameRepository.save(streetFighter5);

        Game tekken = new Game("Tekken", "Katsuhiro Harada",
                5.0,"Fighting", "16");
        gameRepository.save(tekken);

        Game mortalKombat = new Game("Mortal Kombat", "Ed Boon",
                31.99,"Fighting", "18");
        gameRepository.save(mortalKombat);

        Game injustice = new Game("Injustice: Gods Among Us", "Ed Boon",
                27.99,"Fighting", "16");
        gameRepository.save(injustice);

        Game callOfDutyBlackOps2 = new Game("Call Of Duty Black Ops 2", "Jason Blundell",
                32.76,"FPS", "18");
        gameRepository.save(callOfDutyBlackOps2);

        Game callOfDutyModernWarefare= new Game("Call Of Duty Modern Warfare", "Jason Blundell",
                12.96,"FPS", "18");
        gameRepository.save(callOfDutyModernWarefare);

        Game haloReach= new Game("Halo Reach", "Marcus Lehto",
                7.16,"FPS", "16");
        gameRepository.save(haloReach);

        Game halo4= new Game("Halo 4", "Marcus Lehto",
                12.56,"FPS", "16");
        gameRepository.save(halo4);

        Game haloInfinite= new Game("Halo Infinite", "Marcus Lehto",
                77.16,"FPS", "16");
        gameRepository.save(haloInfinite);

        Game finalFantasy7= new Game("Final Fantasy 7", "Nomura",
                14.99,"Fantasy", "16");
        gameRepository.save(finalFantasy7);

        Game darkSiders2= new Game("Darksiders 2", "Joe Madureira",
                4.99,"Fantasy", "18");
        gameRepository.save(darkSiders2);

        Game elderScrollsSkyrim= new Game("Elder Scrolls Skyrim", "Todd Howard",
                14.99,"Fantasy", "18");
        gameRepository.save(elderScrollsSkyrim);

        Game worldOfWarcraft= new Game("World Of Warcraft", "Alex Afrasiabi",
                34.99,"Fantasy", "18");
        gameRepository.save(worldOfWarcraft);

        Game xcom= new Game("XCOM", "Jake Solomon", 44.99,
                "RTS", "18");
        gameRepository.save(xcom);

        Game duneII= new Game("Dune II", "Denis Villeneuve ", 32.99,
                "RTS", "16");
        gameRepository.save(duneII);

        Game suddenStrike4= new Game("Sudden Strike 4", "Attila Bánki-Horváth ", 2.99,
                "RTS", "16");
        gameRepository.save(suddenStrike4);

        Game haloWars= new Game("Halo Wars", "Marcus Lehto ", 0.99,
                "RTS", "16");
        gameRepository.save(haloWars);

        Game soulCaliber= new Game("Soul Caliber", "Yoshinori Takahashi ", 3.99,
                "Fighting", "16");
        gameRepository.save(soulCaliber);

        Game farCry3= new Game("FarCry 3", "Patrick Plourde", 5.99,
                "Open World", "18");
        gameRepository.save(farCry3);

        Game tetris= new Game("Tetris", "Amaury Watine", 52.99,
                "Puzzle", "3");
        gameRepository.save(tetris);

        Game monumentValley= new Game("Monument Valley", "Sam Crisp ", 17.99,
                "Puzzle", "7");
        gameRepository.save(monumentValley);

        Game portal= new Game("portal", "Gabe Newell plz drop Half life 3", 4.99,
                "Puzzle", "12");
        gameRepository.save(portal);

        Game portal2= new Game("portal 2", "Gabe Newell plz drop Half life 3", 4.99,
                "Puzzle", "12");
        gameRepository.save(portal2);

        Game beyondASteelSky= new Game("Beyond A Steel Sky", "Dave Gibbons", 19.68,
                "Puzzle", "12");
        gameRepository.save(beyondASteelSky);

        Game stray= new Game("Stray", "Swann Martin-Raget", 29.99,
                "Puzzle", "12");
        gameRepository.save(stray);

        Game dishonoured= new Game("Dishonoured", "Raphaël Colantonio", 19.99,
                "stealth", "18");
        gameRepository.save(dishonoured);

        Game dishonoured2= new Game("Dishonoured 2", "Raphaël Colantonio", 21.99,
                "stealth", "18");
        gameRepository.save(dishonoured2);

        Game sniperElite= new Game("Sniper Elite", "Andrew Pattinson ", 29.99,
                "stealth", "18");
        gameRepository.save(sniperElite);

        Game assassinsCreedII= new Game("Assassins Creed II", "Patrice Désilets", 9.99,
                "stealth", "18");
        gameRepository.save(assassinsCreedII);

        Game assassinsCreedBrotherhood= new Game("Assassins Creed Brotherhood", "Patrice Désilets", 6.99,
                "stealth", "18");
        gameRepository.save(assassinsCreedBrotherhood);

        Game ghostOfTsushima= new Game("Ghost Of Tsushima", "Nate Fox", 18.99,
                "stealth", "18");
        gameRepository.save(ghostOfTsushima);

        Game halfLife= new Game("Half Life", "Gabe Newell plz drop Half life 3", 7.99,
                "FPS", "18");
        gameRepository.save(halfLife);

        Game overwatch= new Game("Overwatch", " Jeff Kaplan", 26.99,
                "Multiplayer", "12");
        gameRepository.save(overwatch);

        Game overwatch2= new Game("Overwatch 2", " Jeff Kaplan", 0.00,
                "Multiplayer", "12");
        gameRepository.save(overwatch2);

        Game amongUs= new Game("Among US", "Forest Willard", 0.00,
                "Multiplayer", "12");
        gameRepository.save(amongUs);

        Game callOfDutyWarzone= new Game("Call Of Duty Warzone", "Jason Blundell", 0.00,
                "Multiplayer", "18");
        gameRepository.save(callOfDutyWarzone);

        Game fallGuys= new Game("Fall Guys", "Dave Bailey", 20.00,
                "Multiplayer", "7");
        gameRepository.save(fallGuys);

        Game batmanArkhamAsylum= new Game("Batman Arkham Asylum", "David Hego", 10.99,
                "Stealth", "16");
        gameRepository.save(batmanArkhamAsylum);

        Game batmanArkhamOrigin= new Game("Batman Arkham Origin", "David Hego", 11.99,
                "Stealth", "16");
        gameRepository.save(batmanArkhamOrigin);

        Game batmanArkhamCity= new Game("Batman Arkham City", "David Hego", 12.99,
                "Stealth", "16");
        gameRepository.save(batmanArkhamCity);

        Game batmanArkhamKnight= new Game("Batman Arkham Knight", "David Hego", 14.99,
                "Stealth", "16");
        gameRepository.save(batmanArkhamKnight);

        Game marioAndSonicLondonOlympics= new Game("Mario And Sonic London Olympics", "Eigo Kasahara", 29.99,
                "Sport", "16");
        gameRepository.save(marioAndSonicLondonOlympics);

        Game wwe2k14= new Game("WWE 2k14", "Lynell Jink", 3.99,
                "Sport", "16");
        gameRepository.save(wwe2k14);

        Game wwe13= new Game("WWE 13", "Lynell Jink", 1.99,
                "Sport", "16");
        gameRepository.save(wwe13);


        //Account Creation
        Account accountOne = new Account("Will Stanistreet", "12345", "01/01/1992", "will@will.com" );
        accountOne.setWallet(100);
        accountRepository.save(accountOne);
        Account accountTwo = new Account("Shiyi Zhu", "88886", "08/08/2008", "shiyi@shiyi.com");
        accountTwo.setWallet(160);
        accountRepository.save(accountTwo);
        Account accountThree = new Account("Eesaa Sheikh", "63729", "05/01/1996", "eesaa@eesaa.com");
        accountThree.setWallet(500);
        accountRepository.save(accountThree);
        Account accountFour = new Account("Fatimah Patel", "11111", "03/03/1993", "fatimah@fatimah.com");
        accountFour.setWallet(120);
        accountRepository.save(accountFour);

        //Adding games to accounts
        accountService.addGameToAccount(godOfWar, accountOne);
        accountService.addGameToAccount(godOfWar, accountFour);
        accountService.addGameToAccount(eldenRing, accountThree);

        accountRepository.save(accountOne);
        accountRepository.save(accountFour);
        accountRepository.save(accountTwo);

        HashSet<Account>testFriends = new HashSet<>();
        testFriends.add(accountOne);
        testFriends.add(accountThree);

        accountTwo.setFriendsList(testFriends);
        accountThree.setFriendsList(testFriends);
        accountRepository.save(testFriends);

    }

}
