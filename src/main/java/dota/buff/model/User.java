package dota.buff.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String login;
    private String password;
    private Key key;

    public void setKey(String apiKey) {
        this.key.setApiKey(apiKey);
    }
}
