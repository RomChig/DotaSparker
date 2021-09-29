package dota.buff.service;

import dota.buff.exception.DotaSparkerException;
import dota.buff.model.dto.MatchDTO;
import dota.buff.model.SparkerMatchHistoryDetail;

import java.util.List;

public interface PlayerService {

    MatchDTO getLastMatch(long steamId);

    List<SparkerMatchHistoryDetail> getMatches(long steamId, int matches) throws DotaSparkerException;

}
