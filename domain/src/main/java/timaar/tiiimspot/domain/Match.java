package timaar.tiiimspot.domain;

import java.util.List;
import java.util.UUID;

/**
 * Een match heeft een niet nader genoemd aantal matchdelen.
 * Voor voetbal:
 * * jeugd: zijn dit meestal 4 kwarten van 15 of 20 min.
 * * seniors: zijn dit meestal 2 helften van 45 min.
 *
 * @param matchvoorbereidingen
 */
public record Match(UUID id, List<Matchvoorbereiding> matchvoorbereidingen) {

    public Match(List<Matchvoorbereiding> matchvoorbereidingen) {
        this(UUID.randomUUID(), matchvoorbereidingen);
    }
}
