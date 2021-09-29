package dota.buff.service;

import dota.buff.exception.DotaSparkerException;
import dota.buff.model.dto.HeroDTO;
import dota.buff.model.dto.MatchDTO;
import dota.buff.model.dto.PlayerDTO;
import dota.buff.model.enums.Side;

import java.util.List;

public interface MatchService {

    MatchDTO getMatchById(long matchId) throws DotaSparkerException;

    List<PlayerDTO> getAllMatchPlayers(MatchDTO matchDTO);

    List<HeroDTO> getAllMatchHeroes(MatchDTO match);

    Side getWinner(MatchDTO match);

}
