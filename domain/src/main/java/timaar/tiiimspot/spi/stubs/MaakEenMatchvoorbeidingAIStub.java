package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.domain.MatchvoorbereidingGenerationType;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.spi.MaakEenMatchvoorbeidingAI;

import java.util.ArrayList;

@Stub
public class MaakEenMatchvoorbeidingAIStub implements MaakEenMatchvoorbeidingAI {

    @Override
    public Matchvoorbereiding maken(Selectie selectie, Integer aantalMatchDelen, Integer matchdeelTijdInMinuten, Integer validatieMaxTijdVerschilTussenMaxEnMin) {
        // TODO elaborate
        return new Matchvoorbereiding(new ArrayList<>(), MatchvoorbereidingGenerationType.AI);
    }
}
