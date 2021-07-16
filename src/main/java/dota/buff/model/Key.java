package dota.buff.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Key {
    private String apiKey;

    public Key(String apiKey) {
        this.apiKey = apiKey;
    }

}
