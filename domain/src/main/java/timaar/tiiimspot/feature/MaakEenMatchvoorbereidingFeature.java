package timaar.tiiimspot.feature;

import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.domain.Selectie;

public interface MaakEenMatchvoorbereidingFeature {

    Integer DEFAULT_AANTAL_MATCH_DELEN = 4;
    Integer DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN = 20;

    default Matchvoorbereiding maken(Selectie selectie) {
        return this.maken(selectie, DEFAULT_AANTAL_MATCH_DELEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN, Boolean.FALSE);
    }

    default Matchvoorbereiding makenByAI(Selectie selectie) {
        return this.maken(selectie, DEFAULT_AANTAL_MATCH_DELEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN, DEFAULT_AANTAL_MATCHDEEL_TIJD_IN_MINTEN, Boolean.TRUE);
    }

    Matchvoorbereiding maken(Selectie selectie,
                             Integer aantalMatchDelen,
                             Integer matchdeelTijdInMinuten,
                             Integer validatieMaxTijdVerschilTussenMaxEnMin,
                             Boolean withAI);
}
