package dota.buff.service;

import dota.buff.model.dto.HeroDTO;

import java.util.List;

public interface HeroService {

    HeroDTO getHeroById(int heroId);

    List<HeroDTO> getAllHeroes();

}
