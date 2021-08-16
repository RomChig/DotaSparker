package dota.buff.service;

import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.model.match.MatchDetailPlayer;
import dota.buff.model.*;

import java.util.List;

public interface ConvertService {

    public PlayerDTO convertPlayer(MatchDetailPlayer player);

    public HeroDTO convertHero(Hero hero);

    public MatchDTO convertMatch(MatchDetail match);

    public List<PlayerDTO> convertPlayerList(List<MatchDetailPlayer> playerList);

    public List<HeroDTO> convertHeroList(List<Hero> heroList);

}
