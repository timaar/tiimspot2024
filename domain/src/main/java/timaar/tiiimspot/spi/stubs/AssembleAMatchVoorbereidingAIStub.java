package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.Match;
import timaar.tiiimspot.MatchVoorbereiding;
import timaar.tiiimspot.Selectie;
import timaar.tiiimspot.spi.AssembleAMatchVoorbereidingAI;

import java.util.ArrayList;

@Stub
public class AssembleAMatchVoorbereidingAIStub implements AssembleAMatchVoorbereidingAI {
    @Override
    public MatchVoorbereiding createMatchVoorbereiding433(Selectie selectie) {
        // TODO elaborate
        return new MatchVoorbereiding(new Match(new ArrayList<>()));
    }
}
