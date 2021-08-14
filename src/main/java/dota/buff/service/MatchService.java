package dota.buff.service;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;

import java.util.List;

public interface MatchService {
    MatchDTO getMatchById(long matchId);

    List<PlayerDTO> getAllMatchPlayers(long matchId);

    List<HeroDTO> getAllMatchHeroes(long matchId);

    Side getWinner(long matchId);

}
