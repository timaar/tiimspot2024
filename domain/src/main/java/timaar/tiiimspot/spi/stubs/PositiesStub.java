package timaar.tiiimspot.spi.stubs;

import ddd.Stub;
import timaar.tiiimspot.Positie;
import timaar.tiiimspot.spi.Posities;

import java.util.List;

@Stub
public final class PositiesStub implements Posities {

    public static final Positie KEEPER = new Positie("Keeper", 1,1);
    public static final Positie RECHTSBACK = new Positie("Rechtsback", 2,1);
    public static final Positie RECHTER_CENTRALE_VERDEDIGER = new Positie("Rechter Centrale Verdediger", 3,1);
    public static final Positie LINKER_CENTRALE_VERDEDIGER = new Positie("Linker Centrale Verdediger", 4,1);
    public static final Positie LINKSBACK = new Positie("Linksback", 5,1);
    public static final Positie VERDEDIGENDE_MIDDENVELDER = new Positie("Verdedigende Middenvelder", 6,1);
    public static final Positie BOX_TO_BOX_MIDDENVELDER = new Positie("Box to Box Middenvelder", 8,1);
    public static final Positie AANVALLENDE_MIDDENVELDER = new Positie("Aanvallende Middenvelder", 10,1);
    public static final Positie RECHTERVLEUGELAANVALLER = new Positie("Rechtervleugelaanvaller", 7,1);
    public static final Positie LINKERVLEUGELAANVALLER = new Positie("Linkervleugelaanvaller", 11,1);
    public static final Positie SPITS = new Positie("Spits", 9,1);
    public static final Positie BANK = new Positie("Bank", null,5);

    @Override
    public List<Positie> getPosities433() {
        return List.of(KEEPER, RECHTSBACK, RECHTER_CENTRALE_VERDEDIGER, LINKER_CENTRALE_VERDEDIGER, LINKSBACK, VERDEDIGENDE_MIDDENVELDER, BOX_TO_BOX_MIDDENVELDER, AANVALLENDE_MIDDENVELDER,
                RECHTERVLEUGELAANVALLER, LINKERVLEUGELAANVALLER, SPITS, BANK);
    }
}
