package timaar.tiiimspot.spi;

import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.domain.Selectie;

public interface MaakEenMatchvoorbeidingAI {

    Matchvoorbereiding maken(Selectie selectie, Integer aantalMatchDelen, Integer matchdeelTijdInMinuten, Integer validatieMaxTijdVerschilTussenMaxEnMin);
}
