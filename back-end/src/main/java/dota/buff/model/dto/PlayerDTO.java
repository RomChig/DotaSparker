package dota.buff.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerDTO {

    long accountId;

    @JsonProperty("hero")
    HeroDTO heroDTO;

    int kills;

    int deaths;

    int assists;

    int gold;

}
