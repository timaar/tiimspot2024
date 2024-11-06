package timaar.tiiimspot.spi;

import timaar.tiiimspot.domain.MatchVoorbereiding;
import timaar.tiiimspot.domain.Selectie;

public interface MaakEenMatchVoorbeidingAI {

    MatchVoorbereiding maken(Selectie selectie);
}
