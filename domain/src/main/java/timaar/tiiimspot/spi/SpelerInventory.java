package timaar.tiiimspot.spi;

import timaar.tiiimspot.domain.Speler;

import java.util.List;

public interface SpelerInventory {

    List<Speler> getSpelers();

    void saveSpeler(Speler speler);
}
