package timaar.tiiimspot.spi;

import timaar.tiiimspot.Speler;

import java.util.List;

public interface Spelers {

    List<Speler> getSpelers();

    void saveSpeler(Speler speler);
}
