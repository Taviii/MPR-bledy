package pl.pjatk.gameplay.player.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.player.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DamageServiceTest {

    private final DamageService damageService = new DamageService();

//    @Test
//    void shouldNotLetPlayerDie(){\
//        //given
//        Player player = new Player("Test player 1", 100, 100, 10);
//
//
//        //when
//        damageService.undead(2, "Test player 1");
//
//        //then
//        assertThat("").isEqualTo("");
//}

// do zmiany potrm//
@Test
void shouldMakeMoreAttack(){
    //given
    Player player = new Player("test player", 100, 100, 10);
    //when
    damageService.morePowerOfAttack(player, 30);
    //then
    assertThat(player.getAttack()).isEqualTo(30);
}

    @Test
    void shouldMakeZeroAttack(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.morePowerOfAttack(player, 0);
        //then
        assertThat(player.getAttack()).isZero();
    }


    @Test
    void shouldChangeNickName(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.changeNickname(player, "1234567890");
        //then
        assertThat(player.getNickname()).isEqualTo("1234567890");
    }

    @Test
    void shouldNotChangeNickName(){
        //given
        Player player = new Player("test player", 100, 100, 10);
        //when
        damageService.changeNickname(player, "asdfghjk");
        //then
//        assertThat(player.()).isEqualTo("test player");
        assertThat(player.getNickname().length()).isGreaterThan(10);


    }
}
