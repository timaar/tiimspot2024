package timaar.tiiimspot.domain;

import java.util.UUID;

/**
 * Een matchvoorbereiding heeft een match.
 * Dit kan later uitgebreid worden met oa: coachingrichtlijnen, beurtrolTruitjes, ...
 *
 * @param match
 */
public record Matchvoorbereiding(UUID id, Match match) {
    public Matchvoorbereiding(Match match) {
        this(UUID.randomUUID(), match);
    }
}
