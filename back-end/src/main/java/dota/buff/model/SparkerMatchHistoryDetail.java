package dota.buff.model;

import com.github.wannesvr.core.model.match.LobbyType;
import com.github.wannesvr.core.model.match.MatchHistoryDetail;
import com.github.wannesvr.core.model.match.MatchHistoryPlayer;
import dota.buff.service.impl.DateConverter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SparkerMatchHistoryDetail {
    long matchId;

    long matchSequenceNumber;

    String startTime;

    LobbyType lobbyType;

    int radiantTeamId;

    int direTeamId;

    List<MatchHistoryPlayer> players;

    public SparkerMatchHistoryDetail(MatchHistoryDetail matchHistoryDetail) {
        this.matchId = matchHistoryDetail.getMatchId();
        this.matchSequenceNumber = matchHistoryDetail.getMatchSequenceNumber();
        this.startTime = DateConverter.convert(matchHistoryDetail.getStartTime());
        this.lobbyType = matchHistoryDetail.getLobbyType();
        this.radiantTeamId = matchHistoryDetail.getRadiantTeamId();
        this.direTeamId = matchHistoryDetail.getDireTeamId();
        this.players = matchHistoryDetail.getPlayers();
    }
}
