package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.*;
import com.github.wannesvr.core.request.match.MatchDetailRequest;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.service.HeroService;
import dota.buff.service.MatchService;

import java.util.ArrayList;
import java.util.List;

public class MatchServiceImpl implements MatchService {

    private static final String API_KEY = "B946D0A6B0726327F1C9D44095CD11C0";
    private static final Dota2ApiClient client = new Dota2ApiClient(API_KEY);
    private static final HeroService heroService = new HeroServiceImpl();

    @Override
    public MatchDTO getMatchById(long matchId) {
        MatchDetail matchDetail = client.send(getMatchDetailRequest(matchId));
        return new MatchDTO(
                matchDetail.getMatchId(),
                matchDetail.getGameMode().toString(),
                convertAllMatchPlayers(matchDetail),
                convertAllMatchHeroes(convertAllMatchPlayers(matchDetail)),
                matchDetail.isRadiantWin(),
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
    public void getWinner(long matchId) {
        if (getMatchById(matchId).isRadiantWinner()) {
            System.out.println("Radiant is winner");
        } else {
            System.out.println("Dire is winner");
        }
    }

    private MatchDetailRequest getMatchDetailRequest(long matchId) {
        return new MatchDetailRequest.Builder(matchId).build();
    }

    private List<PlayerDTO> convertAllMatchPlayers(MatchDetail matchDetail) {
        List<PlayerDTO> list = new ArrayList<>();
        if (matchDetail != null) {
            for (int i = 0; i < matchDetail.getPlayers().size(); i++) {
                MatchDetailPlayer detail = matchDetail.getPlayers().get(i);
                PlayerDTO player = new PlayerDTO(
                        detail.getAccountId(),
                        heroService.getHeroById(detail.getHeroId()),
                        detail.getKills(),
                        detail.getDeaths(),
                        detail.getAssists(),
                        detail.getGoldSpent()
                );
                list.add(player);
            }
        }
        return list;
    }

    private List<HeroDTO> convertAllMatchHeroes(List<PlayerDTO> playerList) {
        List<HeroDTO> heroList = new ArrayList<>();
        for (PlayerDTO player : playerList) {
            HeroDTO hero = heroService.getHeroById(player.getHeroDTO().getId());
            heroList.add(hero);
        }
        return heroList;
    }
}

