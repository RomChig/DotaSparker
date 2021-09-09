package dota.buff.controller;

import dota.buff.model.HeroDTO;
import dota.buff.model.MatchDTO;
import dota.buff.model.PlayerDTO;
import dota.buff.model.enums.Side;
import dota.buff.service.MatchService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/match")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Long id){
        return new ResponseEntity<>(matchService.getMatchById(id), HttpStatus.OK);
    }

    @GetMapping("/players/match/{id}")
    public ResponseEntity<List<PlayerDTO>> getAllMatchPlayersById(@PathVariable Long id){
        return new ResponseEntity<>(matchService.getAllMatchPlayers(matchService.getMatchById(id)), HttpStatus.OK);
    }

    @GetMapping("/heroes/match/{id}")
    public ResponseEntity<List<HeroDTO>> getAllMatchHeroesById(@PathVariable Long id){
        return new ResponseEntity<>(matchService.getAllMatchHeroes(matchService.getMatchById(id)), HttpStatus.OK);
    }

    @GetMapping("/winner/match/{id}")
    public ResponseEntity<Side> getWinnerById(@PathVariable Long id){
        return new ResponseEntity<>(matchService.getWinner(matchService.getMatchById(id)), HttpStatus.OK);
    }

}