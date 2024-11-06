package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.domain.Match;
import timaar.tiiimspot.domain.MatchVoorbereiding;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.spi.MaakEenMatchVoorbeidingAI;

import java.util.ArrayList;

@Stub
public class MaakEenMatchVoorbeidingAIStub implements MaakEenMatchVoorbeidingAI {

    @Override
    public MatchVoorbereiding maken(Selectie selectie) {
        // TODO elaborate
        return new MatchVoorbereiding(new Match(new ArrayList<>()));
    }
}
