package timaar.tiiimspot.api;

import timaar.tiiimspot.MatchVoorbereiding;
import timaar.tiiimspot.Selectie;

public interface AssembleAMatchVoorbereiding {

    Integer DEFAULT_AANTAL_MATCH_DELEN = 4;
    Integer DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN = 20;

    MatchVoorbereiding createMatchVoorbereiding(Selectie selectie, Integer aantalMatchDelen, Integer matchdeelTijdInMinuten);

    default MatchVoorbereiding createMatchVoorbereiding(Selectie selectie) {
        return this.createMatchVoorbereiding(selectie, DEFAULT_AANTAL_MATCH_DELEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN);
    }
}
