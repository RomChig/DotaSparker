package dota.buff.controller;

import dota.buff.model.dto.HeroDTO;
import dota.buff.service.HeroService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Integer id) {
        log.info("Request for get hero by id: {}", id);
        return new ResponseEntity<>(heroService.getHeroById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HeroDTO>> getAllHeroes() {
        log.info("Request for get all heroes");
        return new ResponseEntity<>(heroService.getAllHeroes(), HttpStatus.OK);
    }
}
