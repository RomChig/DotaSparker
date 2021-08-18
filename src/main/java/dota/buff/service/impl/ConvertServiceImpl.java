package dota.buff.service.impl;

import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.model.match.MatchDetailPlayer;

import dota.buff.model.*;
import dota.buff.model.enums.Side;
import dota.buff.service.ConvertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService {

    private final List<HeroDTO> heroList;

    @Autowired
    public ConvertServiceImpl(List<Hero> allHeroes) {
        this.heroList = convertHeroList(allHeroes);
    }

    @Override
    public PlayerDTO convertPlayer(MatchDetailPlayer player) {
        return new PlayerDTO(
                player.getAccountId(),
                heroList.stream()
                        .filter(heroDTO -> player.getHeroId() == heroDTO.getId())
                        .findFirst().orElse(null),
                player.getKills(),
                player.getDeaths(),
                player.getAssists(),
                player.getGoldSpent()
        );
    }

    @Override
    public HeroDTO convertHero(Hero hero) {
        return new HeroDTO(hero.getId(), hero.getName(), hero.getLocalizedName());
    }

    @Override
    public MatchDTO convertMatch(MatchDetail match) {
        return new MatchDTO(
                match.getMatchId(),
                String.valueOf(match.getGameMode()),
                convertPlayerList(match.getPlayers()),
                match.isRadiantWin() ? Side.RADIANT : Side.DIRE,
                match.getDuration());
    }

    @Override
    public List<PlayerDTO> convertPlayerList(List<MatchDetailPlayer> playerList) {
        List<PlayerDTO> list = new ArrayList<>();
        for (MatchDetailPlayer detail : playerList) {
            list.add(convertPlayer(detail));
        }
        return list;
    }

    @Override
    public List<HeroDTO> convertHeroList(List<Hero> heroList) {
        List<HeroDTO> heroDTOList = new ArrayList<>();
        for (Hero hero : heroList) {
            heroDTOList.add(convertHero(hero));
        }
        return heroDTOList;
    }

}
