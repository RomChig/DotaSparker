package dota.buff.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private Key key;

    public void setKey(String apiKey) {
        this.key.setApiKey(apiKey);
    }
}
