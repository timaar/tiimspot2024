package timaar.tiiimspot;

import java.util.Map;
import java.util.UUID;

public record Speler(UUID id, String naam, String voornaam, Map<Positie,Integer> positieQuotering) {
    public Speler(String naam, String voornaam, Map<Positie,Integer> positieQuotering) {
        this(UUID.randomUUID(), naam, voornaam, positieQuotering);
    }
}
