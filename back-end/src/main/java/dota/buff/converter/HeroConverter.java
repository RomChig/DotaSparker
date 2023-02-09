package dota.buff.converter;

import com.github.wannesvr.core.model.hero.Hero;
import dota.buff.model.dto.HeroDTO;
import org.springframework.stereotype.Component;

@Component
public class HeroConverter implements Converter<Hero, HeroDTO> {

    @Override
    public HeroDTO convert(Hero hero) {
        return new HeroDTO(
                hero.getId(), hero.getName(), hero.getLocalizedName()
        );
    }
}
