package dota.buff;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.GameMode;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.request.match.MatchHistoryRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DotaSparkerApplication {

	private static final String API_KEY = "B946D0A6B0726327F1C9D44095CD11C0";

	public static void main(String[] args) {
		SpringApplication.run(DotaSparkerApplication.class, args);
		Dota2ApiClient dota2ApiClient = new Dota2ApiClient(API_KEY);
		MatchHistoryRequest request = new MatchHistoryRequest.Builder()
				.gameMode(GameMode.ALL_PICK)
				.matchesRequested(5)
				.build();
		MatchHistory matchHistory = dota2ApiClient.send(request);
		System.out.println(matchHistory.getMatches());
	}

}
