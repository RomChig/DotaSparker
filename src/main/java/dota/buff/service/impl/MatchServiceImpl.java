package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.*;
import com.github.wannesvr.core.request.match.MatchDetailRequest;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;
import dota.buff.service.ConvertService;
import dota.buff.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final Dota2ApiClient client;
    private final ConvertService convertService;


    @Autowired
    public MatchServiceImpl(Dota2ApiClient client, ConvertService convertService) {
        this.client = client;
        this.convertService = convertService;
    }

    @Override
    public MatchDTO getMatchById(long matchId) {
        MatchDetail matchDetail = client.send(new MatchDetailRequest.Builder(matchId).build());
        if (matchDetail.getMatchId() == 0) {
            throw new IllegalArgumentException("Match is null");
        }
        return convertService.convertMatch(matchDetail);
    }

    @Override
    public List<PlayerDTO> getAllMatchPlayers(MatchDTO match) {
        if (match.getMatchId() == 0) {
            throw new IllegalArgumentException("Match does not exist");
        }
        return match.getPlayerList();
    }

    @Override
    public List<HeroDTO> getAllMatchHeroes(MatchDTO match) {
        if (match.getMatchId() == 0) {
            throw new IllegalArgumentException("Match does not exist");
        }
        List<HeroDTO> heroList = new ArrayList<>();
        for (PlayerDTO player : getAllMatchPlayers(match)) {
            heroList.add(player.getHeroDTO());
        }
        return heroList;
    }

    @Override
    public Side getWinner(MatchDTO match) {
        if (match.getMatchId() == 0) {
            throw new IllegalArgumentException("Match does not exist");
        }
        return match.getSide();
    }

}

