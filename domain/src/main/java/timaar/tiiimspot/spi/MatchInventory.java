package timaar.tiiimspot.spi;


import timaar.tiiimspot.domain.Match;

import java.util.UUID;

public interface MatchInventory {

    void saveMatch(Match match);

    Match getById(UUID id);
}
