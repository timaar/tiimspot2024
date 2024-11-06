package timaar.tiiimspot.domain;

import java.util.Map;
import java.util.UUID;

/**
 *
 * @param id Database id
 * @param naam
 * @param voornaam
 * @param positieQuotering Een speler kan voor een bepaalde positie een quotering krijgen van hoe goed of minder goed die speler is op die bepaalde positie
 */
public record Speler(UUID id, String naam, String voornaam, Map<Positie,Integer> positieQuotering) {
    public Speler(String naam, String voornaam, Map<Positie,Integer> positieQuotering) {
        this(UUID.randomUUID(), naam, voornaam, positieQuotering);
    }
}
