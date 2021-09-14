package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.request.match.MatchHistoryRequest;

import dota.buff.exception.DotaSparkerException;
import dota.buff.model.MatchDTO;
import dota.buff.service.MatchService;
import dota.buff.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final Dota2ApiClient client;
    private final MatchService matchService;

    @Override
    public MatchDTO getLastMatch(long steamId) {
        log.info("Getting last user match with steamId: " + steamId);
        return getMatches(steamId, 1).get(0);
    }

    @Override
    public List<MatchDTO> getMatches(long steamId, int matches) throws DotaSparkerException {
        log.info("Getting " + matches + " user matches with steamId: " + steamId);
        MatchHistory matchHistory = client.send(new MatchHistoryRequest.Builder()
                .accountId(steamId)
                .matchesRequested(matches)
                .build()
        );
        if (matchHistory.getTotalResults() == 0) {
            log.warn("Matches were not found with steamId:" + steamId);
            throw new DotaSparkerException("Matches were not found");
        }
        return matchHistory.getMatches()
                .stream()
                .map(MatchHistoryDetail -> matchService.getMatchById(MatchHistoryDetail.getMatchId()))
                .collect(Collectors.toList());
    }

}
