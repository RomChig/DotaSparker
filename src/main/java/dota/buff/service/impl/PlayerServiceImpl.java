package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.request.match.MatchHistoryRequest;

import dota.buff.exception.DotaSparkerException;
import dota.buff.model.MatchDTO;
import dota.buff.service.MatchService;
import dota.buff.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Dota2ApiClient client;
    private final MatchService matchService;

    @Autowired
    public PlayerServiceImpl(Dota2ApiClient client, MatchService matchService) {
        this.client = client;
        this.matchService = matchService;
    }

    @Override
    public MatchDTO getLastMatch(long steamId) {
        return getMatches(steamId, 1).get(0);
    }

    @Override
    public List<MatchDTO> getMatches(long steamId, int matches) throws DotaSparkerException {
        MatchHistory matchHistory = client.send(new MatchHistoryRequest.Builder()
                .accountId(steamId)
                .matchesRequested(matches)
                .build()
        );
        if (matchHistory.getTotalResults() == 0) {
            throw new DotaSparkerException("Matches were not found");
        }
        return matchHistory.getMatches()
                .stream()
                .map(MatchHistoryDetail -> matchService.getMatchById(MatchHistoryDetail.getMatchId()))
                .collect(Collectors.toList());
    }

}
