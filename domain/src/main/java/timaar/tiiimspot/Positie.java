package timaar.tiiimspot;

import java.util.UUID;

/**
 *
 * Een positie op het veld
 *
 * @param id Database Id van de positie
 * @param naam
 * @param positieNummer
 * @param aantalSpelers max. aantal spelers die hier tegelijk kunnen spelen
 */
public record Positie(UUID id, String naam, Integer positieNummer, Integer aantalSpelers) {
    public Positie(String naam, Integer positieNummer, Integer aantalSpelers) {
        this(UUID.randomUUID(), naam, positieNummer, aantalSpelers);
    }
}
