package timaar.tiiimspot.domain;

import java.util.List;

/**
 * Een matchvoorbereiding heeft een match.
 * Dit kan later uitgebreid worden met oa: coachingrichtlijnen, beurtrolTruitjes, ...
 *
 * @param matchDelen
 * @param type
 */
public record Matchvoorbereiding(List<MatchDeel> matchDelen, MatchvoorbereidingGenerationType type) {

    public int totalPlayingTime() {
        return matchDelen.stream()
                .mapToInt(MatchDeel::tijdsDuurInMinuten)
                .sum();
    }
}
