package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.spi.MatchvoorbereidingInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Stub
public class MatchvoorbereidingInventoryStub implements MatchvoorbereidingInventory {

    private final Map<UUID, Matchvoorbereiding> matchvoorbereidingen = new HashMap<>();

    @Override
    public void saveMatchvoorbereiding(Matchvoorbereiding matchVoorbereiding) {
        matchvoorbereidingen.put(matchVoorbereiding.id(), matchVoorbereiding);
    }

    @Override
    public Matchvoorbereiding getById(UUID id) {
        return matchvoorbereidingen.get(id);
    }
}
