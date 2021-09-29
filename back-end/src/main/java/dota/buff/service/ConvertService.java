package dota.buff.service;

import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.model.match.MatchDetailPlayer;
import com.github.wannesvr.core.model.match.MatchHistoryDetail;
import dota.buff.model.dto.HeroDTO;
import dota.buff.model.dto.MatchDTO;
import dota.buff.model.dto.PlayerDTO;
import dota.buff.model.SparkerMatchHistoryDetail;

import java.util.List;

public interface ConvertService {

    PlayerDTO convertPlayer(MatchDetailPlayer player);

    HeroDTO convertHero(Hero hero);

    MatchDTO convertMatch(MatchDetail match);

    SparkerMatchHistoryDetail convertMatchHistoryDetail(MatchHistoryDetail matchHistoryDetail);

    List<PlayerDTO> convertPlayerList(List<MatchDetailPlayer> playerList);

    List<HeroDTO> convertHeroList(List<Hero> heroList);

}
