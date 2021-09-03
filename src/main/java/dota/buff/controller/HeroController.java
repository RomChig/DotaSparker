package dota.buff.controller;

import dota.buff.model.HeroDTO;
import dota.buff.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hero")
public class HeroController {
    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/{id}")
    public HeroDTO getHeroById(@PathVariable Integer id){
        return heroService.getHeroById(id);
    }

    @GetMapping("/all")
    public List<HeroDTO> getAllHeroes(){
        return heroService.getAllHeroes();
    }

}
