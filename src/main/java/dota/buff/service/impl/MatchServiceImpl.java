package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.request.match.MatchDetailRequest;

import dota.buff.exception.DotaSparkerException;
import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;
import dota.buff.service.ConvertService;
import dota.buff.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public MatchDTO getMatchById(long matchId) throws DotaSparkerException {
        MatchDetail matchDetail = client.send(new MatchDetailRequest.Builder(matchId).build());
        if (matchDetail.getMatchId() == 0) {
            throw new DotaSparkerException(
                    String.format("Match was not found with matchId %d", matchId)
            );
        }
        return convertService.convertMatch(matchDetail);
    }

    @Override
    public List<PlayerDTO> getAllMatchPlayers(MatchDTO match) {
        return match.getPlayerList();
    }

    @Override
    public List<HeroDTO> getAllMatchHeroes(MatchDTO match) {
        return getAllMatchPlayers(match).stream().map(PlayerDTO::getHeroDTO).collect(Collectors.toList());
    }

    @Override
    public Side getWinner(MatchDTO match) {
        return match.getSide();
    }

}

