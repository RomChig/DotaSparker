package dota.buff.service;

import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.model.match.MatchDetailPlayer;
import dota.buff.model.*;

import java.util.List;

public interface ConvertService {

    PlayerDTO convertPlayer(MatchDetailPlayer player);

    HeroDTO convertHero(Hero hero);

    MatchDTO convertMatch(MatchDetail match);

    List<PlayerDTO> convertPlayerList(List<MatchDetailPlayer> playerList);

    List<HeroDTO> convertHeroList(List<Hero> heroList);

}
