package dota.buff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("players")
    List<PlayerDTO> playerList;

    Side side;

    long duration;

}
