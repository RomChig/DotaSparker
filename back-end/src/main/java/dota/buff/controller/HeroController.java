package dota.buff.controller;

import dota.buff.model.HeroDTO;
import dota.buff.service.HeroService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/hero")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Integer id) {
        log.info("Request for get hero by id:" + id);
        return new ResponseEntity<>(heroService.getHeroById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HeroDTO>> getAllHeroes() {
        log.info("Request for get all heroes");
        return new ResponseEntity<>(heroService.getAllHeroes(), HttpStatus.OK);
    }

}
