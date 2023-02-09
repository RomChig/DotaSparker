package dota.buff.converter;


import com.github.wannesvr.core.model.match.MatchDetail;
import dota.buff.model.dto.MatchDTO;
import dota.buff.model.enums.Side;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchConverter implements Converter<MatchDetail, MatchDTO> {
    private final PlayerConverter playerConverter;

    @Override
    public MatchDTO convert(MatchDetail matchDetail) {
        return new MatchDTO(
                matchDetail.getMatchId(),
                String.valueOf(matchDetail.getGameMode()),
                playerConverter.convertList(matchDetail.getPlayers()),
                matchDetail.isRadiantWin() ? Side.RADIANT : Side.DIRE,
                matchDetail.getDuration());
    }
}
