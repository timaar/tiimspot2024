package timaar.tiiimspot.api;

import timaar.tiiimspot.domain.MatchVoorbereiding;
import timaar.tiiimspot.domain.Selectie;

public interface MaakEenMatchVoorbereiding {

    Integer DEFAULT_AANTAL_MATCH_DELEN = 4;
    Integer DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN = 20;

    MatchVoorbereiding maken(Selectie selectie, Integer aantalMatchDelen, Integer matchdeelTijdInMinuten, Integer validatieMaxTijdVerschilTussenMaxEnMin);

    default MatchVoorbereiding maken(Selectie selectie) {
        return this.maken(selectie, DEFAULT_AANTAL_MATCH_DELEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN);
    }
}
