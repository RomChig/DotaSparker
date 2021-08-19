package dota.buff.service.impl;

import com.github.wannesvr.core.model.hero.Hero;

import dota.buff.model.HeroDTO;
import dota.buff.service.ConvertService;
import dota.buff.service.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private final List<HeroDTO> heroList;

    @Autowired
    public HeroServiceImpl(ConvertService convertService, List<Hero> allHeroes) {
        this.heroList = convertService.convertHeroList(allHeroes);
    }

    @Override
    public HeroDTO getHeroById(int heroId) {
        return heroList.stream().filter(hero -> hero.getId() == heroId).findFirst().orElse(null);
    }

    @Override
    public List<HeroDTO> getAllHeroes() {
        return heroList;
    }


}
