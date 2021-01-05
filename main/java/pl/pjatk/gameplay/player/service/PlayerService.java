package pl.pjatk.gameplay.player.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id){    //przez optionala zwraca null jak np damy w postmanie 4 a nie ma id 4
/*        List<Player> players = new ArrayList<>();
        players.add(new Player( 1L,"Player1", 100, 10, 5));
        players.add(new Player(2L,"Player2", 100, 10, 5));
        players.add(new Player(3L,"Player3", 100, 10, 5));*/

        /*players.forEach(player ->{
                player.setAttack(100); //tych ustawień można dać baaardzo dużo
                player.setMana(10);  //też równoznaczne z niższym
                });*/
/*        for (Player player : players){
            player.setMana(10);
        }*/

        /*return players.stream().filter(player -> player.getId() == id).findFirst(); *///tożsame z poniższym komentarzem
/*        for (Player player : players) {
             if (player.getId() == id){
                 return player;
             }
        }
        return new Player();*/

        return playerRepository.findById(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Long id){
        playerRepository.deleteById(id);
    }

    public Player update(long id, Player playerWithupdatedProperties) {
        playerWithupdatedProperties.setId(id);
        if(playerWithupdatedProperties.getHealth() != findById(id).get().getHealth()){
            playerWithupdatedProperties.setHealth(findById(id).get().getHealth());
        }

        return playerRepository.save(playerWithupdatedProperties);
/*        if (findById(updatedPlayer.getId()).isPresent()){
            return playerRepository.save(updatedPlayer);
        }else{
            return null;
        */
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}
