package dota.buff.service.impl;

import dota.buff.model.dto.HeroDTO;
import dota.buff.service.HeroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {

    private final List<HeroDTO> heroList;

    @Override
    public HeroDTO getHeroById(int heroId) {
        log.info("Getting hero by id: {}", heroId);
        return heroList.stream().filter(hero -> hero.getId() == heroId).findFirst().orElse(null);
    }

    @Override
    public List<HeroDTO> getAllHeroes() {
        log.info("Getting all heroes list");
        return heroList;
    }
}
