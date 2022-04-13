package dota.buff.controller;

import dota.buff.model.dto.MatchDTO;
import dota.buff.model.SparkerMatchHistoryDetail;
import dota.buff.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    //TODO steamId put in the path variable isn't safe, should be workable another way.
    @GetMapping("/{steamId}/matches")
    public ResponseEntity<List<SparkerMatchHistoryDetail>> getAmountPlayerMatches(@PathVariable Long steamId, @RequestParam Integer amount) {
        log.info("Request for get {} matches by steamId: {}", amount, steamId);
        return new ResponseEntity<>(playerService.getMatches(steamId, amount), HttpStatus.OK);
    }

    @GetMapping("/{steamId}")
    public ResponseEntity<MatchDTO> getLastMatch(@PathVariable Long steamId) {
        log.info("Request for get last match by steamId: {}", steamId);
        return new ResponseEntity<>(playerService.getLastMatch(steamId), HttpStatus.OK);
    }
}
