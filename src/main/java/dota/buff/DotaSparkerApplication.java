package dota.buff;

import com.github.wannesvr.core.Dota2ApiClient;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.request.match.MatchDetailRequest;
import dota.buff.config.SpringServiceConfig;
import dota.buff.service.impl.HeroServiceImpl;
import dota.buff.service.impl.MatchServiceImpl;
import dota.buff.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;

@SpringBootApplication
public class DotaSparkerApplication {

    private static final long MATCH_ID = 6100763593L;
    private static final long STEAM_ID = 76561198087981013L;

    public static void main(String[] args) {
//        SpringApplication.run(DotaSparkerApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringServiceConfig.class);
        MatchServiceImpl matchService = context.getBean("matchServiceImpl", MatchServiceImpl.class);
        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        HeroServiceImpl heroService = context.getBean("heroServiceImpl", HeroServiceImpl.class);
        System.out.println(heroService.getHeroById(200));

    }



}
