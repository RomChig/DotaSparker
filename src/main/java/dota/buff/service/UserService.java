package dota.buff.service;

import dota.buff.model.MatchDTO;

import java.util.List;

public interface UserService {

    MatchDTO getLastMatch(long steamId);

    List<MatchDTO> getMatches(long steamId, int matches);

}
