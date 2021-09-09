package dota.buff.controller;

import dota.buff.model.HeroDTO;
import dota.buff.service.HeroService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hero")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Integer id) {
        return new ResponseEntity<>(heroService.getHeroById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HeroDTO>> getAllHeroes() {
        return new ResponseEntity<>(heroService.getAllHeroes(), HttpStatus.OK);
    }

}
