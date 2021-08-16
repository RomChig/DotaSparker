package dota.buff.config;

import com.github.wannesvr.core.Dota2ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("dota.buff.service")
@PropertySource("classpath:dota_config.yml")
public class SpringServiceConfig {

    @Value("${dota.api_key}")
    private String API_KEY;

    @Bean
    public Dota2ApiClient dota2ApiClient(){
        return new Dota2ApiClient(API_KEY);
    }

}
