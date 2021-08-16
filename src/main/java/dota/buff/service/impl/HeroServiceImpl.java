package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.hero.Hero;
import com.github.wannesvr.core.model.hero.HeroList;
import com.github.wannesvr.core.request.econ.HeroesRequest;

import dota.buff.model.HeroDTO;
import dota.buff.service.ConvertService;
import dota.buff.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    private final Dota2ApiClient client;
    private final List<HeroDTO> heroList;
    private final ConvertService convertService;

    @Autowired
    public HeroServiceImpl(Dota2ApiClient client, ConvertService convertService) {
        this.client = client;
        this.convertService = convertService;
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
//        List<HeroDTO> list = new ArrayList<>();
        HeroList heroList = client.send(new HeroesRequest.Builder().build());
        if(heroList.getHeroes().size()==0){
            throw new IllegalArgumentException("HeroList is null");
        }
//        for (Hero hero : heroList.getHeroes()) {
//            list.add(new HeroDTO(hero.getId(), hero.getName(), hero.getLocalizedName()));
//        }
//        return list;
        //можно и в одну строчку записать, но пока пусть будет две, чтобы не путаться
        return convertService.convertHeroList(heroList.getHeroes());
    }

}
