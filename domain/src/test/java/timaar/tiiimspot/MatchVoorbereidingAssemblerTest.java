package timaar.tiiimspot;

import org.junit.jupiter.api.Test;
import timaar.tiiimspot.spi.stubs.PositiesStub;
import timaar.tiiimspot.spi.stubs.SpelersStub;

import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatchVoorbereidingAssemblerTest {

    @Test
    void testCreateMatchVoorbereiding() {
        // setup
        Integer aantalMatchDelen = 4;
        Integer matchdeelTijdInMinuten = 20;
        Integer validationMaxTijdVerschilAllowed = 20;
        PositiesStub positiesStub = new PositiesStub();
        SpelersStub spelersStub = new SpelersStub();
        MatchVoorbereidingAssembler matchVoorbereidingAssembler = new MatchVoorbereidingAssembler();
        Selectie selectie = new Selectie(positiesStub.getPosities433(), spelersStub.getSpelers());

        // Call the method to create MatchVoorbereiding
        MatchVoorbereiding matchVoorbereiding = matchVoorbereidingAssembler.createMatchVoorbereiding(
                selectie,
                aantalMatchDelen,
                matchdeelTijdInMinuten,
                validationMaxTijdVerschilAllowed);

        // Assert that the result is not null and should not throw any exceptions
        assertNotNull(matchVoorbereiding, "MatchVoorbereiding should not be null");

        printPlayers(matchVoorbereiding);
    }

    private void printPlayers(MatchVoorbereiding matchVoorbereiding) {
        int deelIndex = 1;
        for (MatchDeel matchDeel : matchVoorbereiding.match().matchDelen()) {
            System.out.println("Match Deel " + deelIndex++ + ":");

            matchDeel.opstelling().entrySet().stream()
                    .sorted(Comparator.comparing(
                            entry -> entry.getKey().positieNummer(),
                            Comparator.nullsLast(Integer::compare)
                    ))
                    .forEach(entry -> {
                        Positie positie = entry.getKey();
                        String positieNummer = positie.positieNummer() != null ? String.valueOf(positie.positieNummer()) : "N/A";
                        String spelerNamen = entry.getValue().stream()
                                .map(speler -> speler.naam() + " " + speler.voornaam())
                                .collect(Collectors.joining(", "));

                        System.out.println(positieNummer + " - " + positie.naam() + ": " + spelerNamen);
                    });
        }
    }
}
