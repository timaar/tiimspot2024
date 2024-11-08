package timaar.tiiimspot.spi;


import timaar.tiiimspot.domain.Matchvoorbereiding;

import java.util.UUID;

public interface MatchvoorbereidingInventory {

    void saveMatchvoorbereiding(Matchvoorbereiding matchVoorbereiding);

    Matchvoorbereiding getById(UUID id);
}
