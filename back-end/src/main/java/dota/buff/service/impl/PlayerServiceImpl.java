package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.request.match.MatchHistoryRequest;
import dota.buff.converter.MatchHistoryDetailConverter;
import dota.buff.exception.DotaSparkerException;
import dota.buff.model.SparkerMatchHistoryDetail;
import dota.buff.model.dto.MatchDTO;
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
    private final MatchHistoryDetailConverter matchHistoryDetailConverter;

    @Override
    public MatchDTO getLastMatch(long steamId) {
        log.info("Getting last user match with steamId: {}", steamId);
        return getMatches(steamId, 1).stream()
                .map(matchHistoryDetail -> matchService.getMatchById(matchHistoryDetail.getMatchId()))
                .findFirst().orElse(null);
    }

    @Override
    public List<SparkerMatchHistoryDetail> getMatches(long steamId, int matches) throws DotaSparkerException {
        log.info("Getting {} user matches with steamId: {}", matches, steamId);
        MatchHistory matchHistory = client.send(new MatchHistoryRequest.Builder()
                .accountId(steamId)
                .matchesRequested(matches)
                .build()
        );
        if (matchHistory.getTotalResults() == 0) {
            log.warn("Matches were not found with steamId: {}", steamId);
            throw new DotaSparkerException("Matches were not found");
        }
        return matchHistory.getMatches()
                .stream()
                .map(matchHistoryDetailConverter::convert)
                .collect(Collectors.toList());
    }
}
