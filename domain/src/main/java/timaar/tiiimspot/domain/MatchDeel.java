package timaar.tiiimspot.domain;

import java.util.List;
import java.util.Map;

/**
 * Een matchdeel heeft een opsetelling en een tijdsduur in minuten
 *
 * @param opstelling
 */
public record MatchDeel(Map<Positie, List<Speler>> opstelling, Integer tijdsDuurInMinuten) {
}
