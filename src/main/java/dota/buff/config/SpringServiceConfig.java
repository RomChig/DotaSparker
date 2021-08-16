package dota.buff.config;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.hero.HeroList;
import com.github.wannesvr.core.request.econ.HeroesRequest;
import dota.buff.model.HeroDTO;
import dota.buff.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan("dota.buff.service")
@PropertySource("classpath:dota_config.yml")
public class SpringServiceConfig {

    @Value("${dota.api_key}")
    private String API_KEY;

    private final ConvertService convertService;

    @Autowired
    public SpringServiceConfig(ConvertService convertService) {
        this.convertService = convertService;
    }

    @Bean
    public Dota2ApiClient dota2ApiClient() {
        return new Dota2ApiClient(API_KEY);
    }

    @Bean
    public List<HeroDTO> allHeroes() {
        HeroList heroList = dota2ApiClient().send(new HeroesRequest.Builder().build());

        if (heroList.getHeroes().size() == 0) {
            throw new IllegalArgumentException("HeroList is null");
        }
        //todo - это к чему коммент внизу?
        //можно и в одну строчку записать, но пока пусть будет две, чтобы не путаться
        return convertService.convertHeroList(heroList.getHeroes());
    }
}
