package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.hero.HeroList;
import com.github.wannesvr.core.request.econ.HeroesRequest;

import dota.buff.model.HeroDTO;
import dota.buff.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private final Dota2ApiClient client;
    private final List<HeroDTO> heroList;

    @Autowired
    public HeroServiceImpl(Dota2ApiClient client) {
        this.client = client;
        this.heroList = initHeroList();
    }

    @Override
    public HeroDTO getHeroById(int heroId) {
        return heroList.stream().filter(hero -> hero.getId() == heroId).findFirst().orElse(null);
    }

    @Override
    public List<HeroDTO> getAllHeroes() {
        return heroList;
    }

    private List<HeroDTO> initHeroList(){
        List<HeroDTO> list = new ArrayList<>();
        HeroList heroList = client.send(getHeroesRequest());
        for (Hero hero : heroList.getHeroes()) {
            list.add(new HeroDTO(hero.getId(), hero.getName(), hero.getLocalizedName()));
        }
        return list;
    }

    private HeroesRequest getHeroesRequest() {
        return new HeroesRequest.Builder().build();
    }
}
