package pl.pjatk.gameplay.player.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.pjatk.gameplay.player.model.Player;
import pl.pjatk.gameplay.player.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock //tu będziemy udawali zachowanie
    private PlayerRepository playerRepository;

    @InjectMocks // a to udawane zachowanie używamy  w playerSercice
    private PlayerService playerService;

    @Test
    void findAll() {
        //Given
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));

        //When
        List<Player> all = playerService.findAll();

        //Then
        assertThat(all).isNotEmpty();

    }


}