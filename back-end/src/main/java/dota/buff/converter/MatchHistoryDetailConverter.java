package dota.buff.converter;


import com.github.wannesvr.core.model.match.MatchHistoryDetail;
import dota.buff.model.SparkerMatchHistoryDetail;
import org.springframework.stereotype.Component;

@Component
public class MatchHistoryDetailConverter implements Converter<MatchHistoryDetail, SparkerMatchHistoryDetail> {

    @Override
    public SparkerMatchHistoryDetail convert(MatchHistoryDetail matchHistoryDetail) {
        return new SparkerMatchHistoryDetail(matchHistoryDetail);
    }
}
