package dota.buff.converter;

import com.github.wannesvr.core.model.match.MatchDetailPlayer;
import dota.buff.model.dto.HeroDTO;
import dota.buff.model.dto.PlayerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerConverter implements Converter<MatchDetailPlayer, PlayerDTO> {

    private List<HeroDTO> heroList;

    @Override
    public PlayerDTO convert(MatchDetailPlayer player) {
        return new PlayerDTO(
                player.getAccountId(),
                heroList.stream()
                        .filter(heroDTO -> player.getHeroId() == heroDTO.getId())
                        .findFirst().orElse(null),
                player.getKills(),
                player.getDeaths(),
                player.getAssists(),
                player.getGoldSpent()
        );
    }
}
