package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.domain.Positie;
import timaar.tiiimspot.domain.Speler;
import timaar.tiiimspot.spi.SpelersInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stub
public final class SpelersInventoryStub implements SpelersInventory {

    private final List<Speler> spelers = new ArrayList<>();

    public SpelersInventoryStub() {
        spelers.add(getNathan());
        spelers.add(getLiam());
        spelers.add(getSophie());
        spelers.add(getNoah());
        spelers.add(getEmma());
        spelers.add(getMilan());
        spelers.add(getZoey());
        spelers.add(getLucas());
        spelers.add(getLara());
        spelers.add(getDaan());
        spelers.add(getZara());
        spelers.add(getFinn());
        spelers.add(getTuur());
        spelers.add(getJani());
        spelers.add(getNoahLefever());
    }

    @Override
    public void saveSpeler(Speler speler) {
        spelers.add(speler);
    }

    @Override
    public List<Speler> getSpelers() {
        return spelers;
    }

    private Speler getNathan() {

        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 5);
        posities.put(PositiesInventoryStub.RECHTSBACK, 5);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 3);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKSBACK, 2);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 2);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 7);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 9);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.SPITS, 9);
        posities.put(PositiesInventoryStub.BANK, 0);

        return new Speler("Nathan", "Van Meerbeeck", posities);
    }

    private Speler getNoahLefever() {

        Map<Positie, Integer> posities = new HashMap<>();

        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 7);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 6);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 9);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,8);
        posities.put(PositiesInventoryStub.BANK, 0);

        return new Speler("Noah", "Lefever", posities);
    }

    private Speler getJani() {

        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 8);
        posities.put(PositiesInventoryStub.RECHTSBACK, 5);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 3);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKSBACK, 2);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 2);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 7);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 9);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.SPITS, 9);
        posities.put(PositiesInventoryStub.BANK, 0);

        return new Speler("Jani", "Dils", posities);
    }

    private Speler getTuur() {

        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 7);
        posities.put(PositiesInventoryStub.RECHTSBACK, 5);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 3);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKSBACK, 2);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 2);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 7);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 9);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.SPITS, 9);
        posities.put(PositiesInventoryStub.BANK, 0);

        return new Speler("Tuur", "Briké", posities);
    }

    private Speler getLiam() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 6);
        posities.put(PositiesInventoryStub.RECHTSBACK, 4);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 3);
        posities.put(PositiesInventoryStub.LINKSBACK, 2);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 5);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 6);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 7);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 5);
        posities.put(PositiesInventoryStub.SPITS, 8);
        posities.put(PositiesInventoryStub.BANK, 1);
        return new Speler("Liam", "Janssens", posities);
    }

    private Speler getSophie() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 4);
        posities.put(PositiesInventoryStub.RECHTSBACK, 3);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 1);
        posities.put(PositiesInventoryStub.LINKSBACK, 5);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 6);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 3);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 7);
        posities.put(PositiesInventoryStub.SPITS, 2);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Sophie", "Verhoeven", posities);
    }

    private Speler getNoah() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 3);
        posities.put(PositiesInventoryStub.RECHTSBACK, 6);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 5);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKSBACK, 3);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 4);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 5);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 9);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 6);
        posities.put(PositiesInventoryStub.SPITS, 3);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Noah", "Peeters", posities);
    }

    private Speler getEmma() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 7);
        posities.put(PositiesInventoryStub.RECHTSBACK, 5);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 6);
        posities.put(PositiesInventoryStub.LINKSBACK, 4);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 3);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,2);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 8);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 5);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 4);
        posities.put(PositiesInventoryStub.SPITS, 8);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Emma", "Brouwer", posities);
    }

    private Speler getMilan() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 2);
        posities.put(PositiesInventoryStub.RECHTSBACK, 3);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 5);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKSBACK, 6);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 3);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,3);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 7);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 6);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 3);
        posities.put(PositiesInventoryStub.SPITS, 5);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Milan", "Vermeulen", posities);
    }

    private Speler getZoey() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 4);
        posities.put(PositiesInventoryStub.RECHTSBACK, 4);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 5);
        posities.put(PositiesInventoryStub.LINKSBACK, 4);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 4);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 4);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 4);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 4);
        posities.put(PositiesInventoryStub.SPITS, 4);
        posities.put(PositiesInventoryStub.BANK, 1);
        return new Speler("Zoey", "Klein", posities);
    }

    private Speler getLucas() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 5);
        posities.put(PositiesInventoryStub.RECHTSBACK, 2);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.LINKSBACK, 3);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 5);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 6);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 7);
        posities.put(PositiesInventoryStub.SPITS, 6);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Lucas", "Vanderlinden", posities);
    }

    private Speler getLara() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 3);
        posities.put(PositiesInventoryStub.RECHTSBACK, 6);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 5);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 3);
        posities.put(PositiesInventoryStub.LINKSBACK, 6);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 7);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 4);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 5);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 6);
        posities.put(PositiesInventoryStub.SPITS, 4);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Lara", "Peters", posities);
    }

    private Speler getDaan() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 5);
        posities.put(PositiesInventoryStub.RECHTSBACK, 5);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 5);
        posities.put(PositiesInventoryStub.LINKSBACK, 3);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 6);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 7);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 6);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 5);
        posities.put(PositiesInventoryStub.SPITS, 8);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Daan", "Lemaire", posities);
    }

    private Speler getZara() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 6);
        posities.put(PositiesInventoryStub.RECHTSBACK, 4);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 5);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKSBACK, 5);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 5);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 6);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 7);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.SPITS, 9);
        posities.put(PositiesInventoryStub.BANK, 1);
        return new Speler("Zara", "De Vos", posities);
    }

    private Speler getFinn() {
        Map<Positie, Integer> posities = new HashMap<>();
        posities.put(PositiesInventoryStub.KEEPER, 4);
        posities.put(PositiesInventoryStub.RECHTSBACK, 5);
        posities.put(PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER, 4);
        posities.put(PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER, 2);
        posities.put(PositiesInventoryStub.LINKSBACK, 4);
        posities.put(PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER, 5);
        posities.put(PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,1);
        posities.put(PositiesInventoryStub.AANVALLENDE_MIDDENVELDER, 6);
        posities.put(PositiesInventoryStub.RECHTERVLEUGELAANVALLER, 7);
        posities.put(PositiesInventoryStub.LINKERVLEUGELAANVALLER, 8);
        posities.put(PositiesInventoryStub.SPITS, 6);
        posities.put(PositiesInventoryStub.BANK, 0);
        return new Speler("Finn", "Hendriks", posities);
    }

}
