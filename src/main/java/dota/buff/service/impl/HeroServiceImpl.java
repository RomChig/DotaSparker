package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.hero.HeroList;
import com.github.wannesvr.core.request.econ.HeroesRequest;

import dota.buff.model.HeroDTO;
import dota.buff.service.HeroService;

import java.util.ArrayList;
import java.util.List;


public class HeroServiceImpl implements HeroService {

    private static final String API_KEY = "B946D0A6B0726327F1C9D44095CD11C0";
    private static final Dota2ApiClient client = new Dota2ApiClient(API_KEY);
    private final List<HeroDTO> heroList = getAllHeroes();

    @Override
    public HeroDTO getHeroById(int heroId) {
        HeroDTO heroDTO = null;
        for (HeroDTO hero : heroList) {
            if (hero.getId() == heroId) {
                heroDTO = hero;
            }
        }
        return heroDTO;
    }

    @Override
    public List<HeroDTO> getAllHeroes() {
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
