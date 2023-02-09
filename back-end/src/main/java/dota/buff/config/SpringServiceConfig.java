package dota.buff.config;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.hero.HeroList;
import com.github.wannesvr.core.request.econ.HeroesRequest;
import dota.buff.converter.HeroConverter;
import dota.buff.exception.DotaSparkerException;
import dota.buff.model.dto.HeroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Optional;

@Configuration
@PropertySource("classpath:dota-config.yml")
@RequiredArgsConstructor
public class SpringServiceConfig {

    private final HeroConverter heroConverter;

    @Value("${dota.api_key}")
    private String API_KEY;

    @Bean
    public Dota2ApiClient dota2ApiClient() {
        return new Dota2ApiClient(API_KEY);
    }

    @Bean
    public List<HeroDTO> allHeroes() throws DotaSparkerException {
        HeroList heroList = dota2ApiClient().send(new HeroesRequest.Builder().build());
        return heroConverter.convertList(
                Optional.ofNullable(heroList)
                        .orElseThrow(() -> new DotaSparkerException("List of heroes is empty"))
                        .getHeroes()
        );
    }
}
