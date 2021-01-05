package pl.pjatk.gameplay.player.service;


import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;

import java.util.Optional;
import java.util.Scanner;

@Service
public class DamageService {

    private PlayerService playerService;
//
//    public DamageService(PlayerService playerService) {
//        this.playerService = playerService;
//    }

    public Player playerAttack(long attackId, long defId){
        Optional<Player> Attack = playerService.findById(attackId);
        Optional<Player> Def = playerService.findById(defId);

        if (Attack.isPresent() && Def.isPresent()) {
            int attack = Attack.get().getAttack();
            Player def = Def.get();
            int health = def.getHealth();

            def.setHealth(health - attack);
            playerService.savePlayer(def);

            return def;
        }
        else
            return null;
    }


    //moje metody//

//    public Player undead(int newHealth, String player ){
//        if (player.getHealth() < 15){
//
//            newHealth = player.setHealth(70);
//        }
//    }

    public Player manaForever(Player player){
        if (player.getMana() <5){
            player.setMana(7);
        }
        return player;
    }

//    public Player changeNickname( Player player, String newNickname){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter new nickname:");
//        newNickname = scanner.next();
//        System.out.println(newNickname);
//        player.setNickname(newNickname);
//        return player;
//    }

    // do zmiany potem://

    public int morePowerOfAttack(Player player, int newAttack) {

        if(newAttack > 50) {
            System.out.println("too much attack");
        } else {
            int boostAttack = player.getAttack() + newAttack;
            player.setAttack(boostAttack);
        }
        return player.getAttack();
    }

    public void changeNickname(Player player, String newName){
        if(newName.length()> 10) {
            System.out.println("too long name");
        }
        player.setNickname(newName);
    }

}
