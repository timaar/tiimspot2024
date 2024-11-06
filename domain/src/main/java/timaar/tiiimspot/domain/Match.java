package timaar.tiiimspot.domain;

import java.util.List;

/**
 * Een match heeft een niet nader genoemd aantal matchdelen.
 * Voor voetbal:
 * * jeugd: zijn dit meestal 4 kwarten van 15 of 20 min.
 * * seniors: zijn dit meestal 2 helften van 45 min.
 *
 * @param matchDelen
 */
public record Match(List<MatchDeel> matchDelen) {

    public int totalPlayingTime() {
        return matchDelen.stream()
                .mapToInt(MatchDeel::tijdsDuurInMinuten)
                .sum();
    }
}
