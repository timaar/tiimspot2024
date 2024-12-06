package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.domain.Match;
import timaar.tiiimspot.spi.MatchInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Stub
public class MatchInventoryStub implements MatchInventory {

    private final Map<UUID, Match> matches = new HashMap<>();

    @Override
    public void saveMatch(Match match) {
        matches.put(match.id(), match);
    }

    @Override
    public Match getById(UUID id) {
        return matches.get(id);
    }
}
