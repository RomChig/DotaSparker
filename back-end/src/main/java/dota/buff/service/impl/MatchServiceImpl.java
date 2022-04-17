package dota.buff.service.impl;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.request.match.MatchDetailRequest;

import dota.buff.converter.MatchConverter;
import dota.buff.exception.DotaSparkerException;
import dota.buff.model.dto.HeroDTO;
import dota.buff.model.dto.MatchDTO;
import dota.buff.model.dto.PlayerDTO;
import dota.buff.model.enums.Side;
import dota.buff.service.MatchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final Dota2ApiClient client;
    private final MatchConverter matchConverter;

    @Override
    public MatchDTO getMatchById(long matchId) throws DotaSparkerException {
        log.info("Getting match by id: {}", matchId);
        MatchDetail matchDetail = client.send(new MatchDetailRequest.Builder(matchId).build());
        if (matchDetail.getMatchId() == 0) {
            log.warn("Match was not found with matchId: {}", matchId);
            throw new DotaSparkerException(
                    String.format("Match was not found with matchId %d", matchId)
            );
        }
        return matchConverter.convert(matchDetail);
    }

    @Override
    public List<PlayerDTO> getAllMatchPlayers(MatchDTO match) {
        log.info("Getting all players in match: {}", match);
        return match.getPlayerList();
    }

    @Override
    public List<HeroDTO> getAllMatchHeroes(MatchDTO match) {
        log.info("Getting all heroes in match: {}", match);
        return getAllMatchPlayers(match).stream().map(PlayerDTO::getHeroDTO).collect(Collectors.toList());
    }

    @Override
    public Side getWinner(MatchDTO match) {
        log.info("Getting winner in match {}", match);
        return match.getSide();
    }
}

