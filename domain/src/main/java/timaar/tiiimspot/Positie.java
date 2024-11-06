package timaar.tiiimspot;

import java.util.UUID;

public record Positie(UUID id, String naam, Integer positieNummer, Integer aantalSpelers) {
    public Positie(String naam, Integer positieNummer, Integer aantalSpelers) {
        this(UUID.randomUUID(), naam, positieNummer, aantalSpelers);
    }
}
