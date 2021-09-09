package dota.buff.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeroDTO {
    int id;
    String name;
    String localizedName;
}