package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.*;
import com.github.wannesvr.core.request.match.MatchDetailRequest;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;
import dota.buff.service.ConvertService;
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
    private final ConvertService convertService;


    @Autowired
    public MatchServiceImpl(Dota2ApiClient client, HeroService heroService, ConvertService convertService) {
        this.client = client;
        this.heroService = heroService;
        this.convertService = convertService;
    }

    @Override
    public MatchDTO getMatchById(long matchId) {
        MatchDetail matchDetail = client.send(new MatchDetailRequest.Builder(matchId).build());
        if(matchDetail.getMatchId()==0){
            throw new IllegalArgumentException("Match is null");
        }
//        List<PlayerDTO> allMatchPlayers = convertAllMatchPlayers(matchDetail.getPlayers());
//        return new MatchDTO(
//                matchDetail.getMatchId(),
//                String.valueOf(matchDetail.getGameMode()),
//                convertService.convertPlayerList(matchDetail.getPlayers()),//-
////                allMatchPlayers,
////                convertAllMatchHeroes(allMatchPlayers),
//                matchDetail.isRadiantWin() ? Side.RADIANT : Side.DIRE,
//                matchDetail.getDuration());
        return convertService.convertMatch(matchDetail);
    }

    @Override
    public List<PlayerDTO> getAllMatchPlayers(long matchId) {
        return getMatchById(matchId).getPlayerList();
    }

    @Override
    public List<HeroDTO> getAllMatchHeroes(long matchId) {
//        return getMatchById(matchId).getHeroList();
        List<HeroDTO> heroList = new ArrayList<>();//-
        MatchDTO matchDTO = getMatchById(matchId);//-
        for (PlayerDTO player : matchDTO.getPlayerList()){//-
            heroList.add(player.getHeroDTO());//-
        }
        return heroList;//-
    }

    @Override
    public Side getWinner(long matchId) {
        return getMatchById(matchId).getSide();
    }

//    private Side getWinner(MatchDetail matchDetail) {
//        return matchDetail.isRadiantWin() ? Side.RADIANT : Side.DIRE;
//    }

//    private List<PlayerDTO> convertAllMatchPlayers(List<MatchDetailPlayer> playerList) {
//        List<PlayerDTO> list = new ArrayList<>();
//            for (MatchDetailPlayer detail : playerList) {
//                list.add(new PlayerDTO(
//                        detail.getAccountId(),
////                        heroService.getHeroById(detail.getHeroId()),
//                        detail.getHeroId(), //-
//                        detail.getKills(),
//                        detail.getDeaths(),
//                        detail.getAssists(),
//                        detail.getGoldSpent()));
//            }
//        return list;
//    }
//
//    private List<HeroDTO> convertAllMatchHeroes(List<PlayerDTO> playerList) {
//        List<HeroDTO> heroList = new ArrayList<>();
//        for (PlayerDTO player : playerList) {
////            heroList.add(heroService.getHeroById(player.getHeroDTO().getId()));
//        }
//        return heroList;
//    }

}

