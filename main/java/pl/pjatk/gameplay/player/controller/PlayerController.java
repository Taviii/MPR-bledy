package pl.pjatk.gameplay.player.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.service.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService)
    {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll()
    {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> findByID(@PathVariable int id){
        Optional<Player> byId = playerService.findById((long) id);
        if (byId.isPresent()) {                                   //przez to co tu się dzieje na pustym id 4 zwróci puste, ale status 404 not found
            return ResponseEntity.ok(playerService.findById((long) id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        return ResponseEntity.ok(playerService.save(player));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){

        playerService.delete(id);

        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@RequestBody Player playerWithUpdatedProperties, @PathVariable long id){

        return ResponseEntity.ok(playerService.update(id, playerWithUpdatedProperties));
    }


}
