package timaar.tiiimspot;

import org.junit.jupiter.api.Test;
import timaar.tiiimspot.spi.stubs.PositiesStub;
import timaar.tiiimspot.spi.stubs.SpelersStub;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MatchVoorbereidingAssemblerTest {

    @Test
    void testCreateMatchVoorbereiding() {
        // Standard values for the test
        Integer aantalMatchDelen = 4;
        Integer matchdeelTijdInMinuten = 20;

        Selectie selectie = new Selectie(new PositiesStub().getPosities433(), new SpelersStub().getSpelers());
        // Call the method to create MatchVoorbereiding
        MatchVoorbereiding matchVoorbereiding = new MatchVoorbereidingAssembler().createMatchVoorbereiding(selectie, aantalMatchDelen, matchdeelTijdInMinuten);

        // Assert that the result is not null
        assertNotNull(matchVoorbereiding, "MatchVoorbereiding should not be null");

        printPlayers(matchVoorbereiding);
    }

    private void printPlayers(MatchVoorbereiding matchVoorbereiding) {
        // Print out players for each MatchDeel
        for (int i = 0; i < matchVoorbereiding.match().matchDeel().size(); i++) {
            MatchDeel matchDeel = matchVoorbereiding.match().matchDeel().get(i);
            System.out.println("Match Deel " + (i + 1) + ":");

            // Sort positions based on positieNummer, handling nulls by placing them last
            matchDeel.opstelling().entrySet().stream()
                    .sorted(Comparator.comparing(
                            entry -> entry.getKey().positieNummer(),
                            Comparator.nullsLast(Integer::compare)
                    ))
                    .forEach(entry -> {
                        Positie positie = entry.getKey();
                        List<Speler> spelers = entry.getValue(); // Get the list of players for this position

                        String positieNummer = (positie.positieNummer() != null) ? String.valueOf(positie.positieNummer()) : "N/A";

                        // Create a comma-separated list of player names
                        String spelerNamen = spelers.stream()
                                .map(speler -> speler.naam() + " " + speler.voornaam())
                                .collect(Collectors.joining(", "));

                        // Print the position and the list of player names
                        System.out.println(positieNummer + " - " + positie.naam() + ": " + spelerNamen);
                    });
        }
    }
}
