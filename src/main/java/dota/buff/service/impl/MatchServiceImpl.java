package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.*;
import com.github.wannesvr.core.request.match.MatchDetailRequest;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;
import dota.buff.service.HeroService;
import dota.buff.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final Dota2ApiClient client;
    private final HeroService heroService;

    @Autowired
    public MatchServiceImpl(Dota2ApiClient client, HeroService heroService) {
        this.client = client;
        this.heroService = heroService;
    }

    @Override
    public MatchDTO getMatchById(long matchId) {
        MatchDetail matchDetail = client.send(getMatchDetailRequest(matchId));
        return new MatchDTO(
                matchDetail.getMatchId(),
                matchDetail.getGameMode().toString(),
                convertAllMatchPlayers(matchDetail.getPlayers()),
                convertAllMatchHeroes(convertAllMatchPlayers(matchDetail.getPlayers())),
                getWinner(matchDetail),
                matchDetail.getDuration());
    }

    @Override
    public List<PlayerDTO> getAllMatchPlayers(long matchId) {
        return getMatchById(matchId).getPlayerList();
    }

    @Override
    public List<HeroDTO> getAllMatchHeroes(long matchId) {
        return getMatchById(matchId).getHeroList();
    }

    @Override
    public Side getWinner(long matchId) {
        return getMatchById(matchId).getSide();
    }

    private Side getWinner(MatchDetail matchDetail) {
        return matchDetail.isRadiantWin() ? Side.RADIANT : Side.DIRE;
    }

    private List<PlayerDTO> convertAllMatchPlayers(List<MatchDetailPlayer> playerList) {
        List<PlayerDTO> list = new ArrayList<>();
        for (MatchDetailPlayer detail : playerList) {
            list.add(new PlayerDTO(
                    detail.getAccountId(),
                    heroService.getHeroById(detail.getHeroId()),
                    detail.getKills(),
                    detail.getDeaths(),
                    detail.getAssists(),
                    detail.getGoldSpent()));
        }
        return list;
    }

    private List<HeroDTO> convertAllMatchHeroes(List<PlayerDTO> playerList) {
        List<HeroDTO> heroList = new ArrayList<>();
        for (PlayerDTO player : playerList) {
            heroList.add(heroService.getHeroById(player.getHeroDTO().getId()));
        }
        return heroList;
    }

    private MatchDetailRequest getMatchDetailRequest(long matchId) {
        return new MatchDetailRequest.Builder(matchId).build();
    }
}

