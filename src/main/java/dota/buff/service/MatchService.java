package dota.buff.service;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;

import java.util.List;

public interface MatchService {

    MatchDTO getMatchById(long matchId);

    List<PlayerDTO> getAllMatchPlayers(MatchDTO matchDTO);

    List<HeroDTO> getAllMatchHeroes(MatchDTO match);

    Side getWinner(MatchDTO match);

}
