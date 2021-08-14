package dota.buff.model;

import dota.buff.model.enums.Side;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchDTO {
    long matchId;
    String gameMode;
    List<PlayerDTO> playerList;
    List<HeroDTO> heroList;
    Side side;
    long duration;

}
