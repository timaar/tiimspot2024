package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.domain.Match;
import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.spi.MaakEenMatchvoorbeidingAI;

import java.util.ArrayList;

@Stub
public class MaakEenMatchvoorbeidingAIStub implements MaakEenMatchvoorbeidingAI {

    @Override
    public Matchvoorbereiding maken(Selectie selectie) {
        // TODO elaborate
        return new Matchvoorbereiding(new Match(new ArrayList<>()));
    }
}
