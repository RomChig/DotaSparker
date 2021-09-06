package dota.buff;

import dota.buff.config.SpringServiceConfig;
import dota.buff.service.impl.HeroServiceImpl;
import dota.buff.service.impl.MatchServiceImpl;
import dota.buff.service.impl.PlayerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DotaSparkerApplication {

    private static final long MATCH_ID = 6100763593L;
    private static final long STEAM_ID = 76561198087981013L;

    public static void main(String[] args) {
        SpringApplication.run(DotaSparkerApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringServiceConfig.class);
        MatchServiceImpl matchService = context.getBean("matchServiceImpl", MatchServiceImpl.class);
        PlayerServiceImpl playerService = context.getBean("playerServiceImpl", PlayerServiceImpl.class);
        HeroServiceImpl heroService = context.getBean("heroServiceImpl", HeroServiceImpl.class);

    }

}
