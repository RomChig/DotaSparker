package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.model.match.MatchHistoryDetail;
import com.github.wannesvr.core.request.match.MatchHistoryRequest;

import dota.buff.model.MatchDTO;
import dota.buff.service.MatchService;
import dota.buff.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final String API_KEY = "B946D0A6B0726327F1C9D44095CD11C0";
    private static final Dota2ApiClient client = new Dota2ApiClient(API_KEY);
    private static final MatchService matchService = new MatchServiceImpl();

    @Override
    public MatchDTO getLastMatch(long steamId) {
        return getMatches(steamId, 1).get(0);
    }

    @Override
    public List<MatchDTO> getMatches(long steamId, int matches) {
        List<MatchDTO> matchList = new ArrayList<>();
        MatchHistory matchHistory = client.send(getMatchHistoryRequest(steamId, matches));
        for (MatchHistoryDetail matchDetail : matchHistory.getMatches()) {
            matchList.add(matchService.getMatchById(matchDetail.getMatchId()));
        }
        return matchList;
    }

    private MatchHistoryRequest getMatchHistoryRequest(long steamId, int matches) {
        return new MatchHistoryRequest.Builder().accountId(steamId).matchesRequested(matches).build();
    }


}
