package timaar.tiiimspot.spi;

import timaar.tiiimspot.domain.Speler;

import java.util.List;

public interface Spelers {

    List<Speler> getSpelers();

    void saveSpeler(Speler speler);
}
