package dota.buff.service;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;

import java.util.List;

public interface MatchService {
    MatchDTO getMatchById(long matchId);

    List<PlayerDTO> getAllMatchPlayers(long matchId);

    List<HeroDTO> getAllMatchHeroes(long matchId);

    void getWinner(long matchId);

}
