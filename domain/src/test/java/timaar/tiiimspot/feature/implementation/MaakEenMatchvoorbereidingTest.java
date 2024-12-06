package timaar.tiiimspot.feature.implementation;

import org.junit.jupiter.api.Test;
import timaar.tiiimspot.domain.MatchDeel;
import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.domain.Positie;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.spi.stubs.MaakEenMatchvoorbeidingAIStub;
import timaar.tiiimspot.spi.stubs.PositiesInventoryStub;
import timaar.tiiimspot.spi.stubs.SpelersInventoryStub;

import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MaakEenMatchvoorbereidingTest {

    @Test
    void testMaken() {
        // setup
        var aantalMatchDelen = 4;
        var matchdeelTijdInMinuten = 20;
        var validationMaxTijdVerschilAllowed = 20;
        var positiesInventoryStub = new PositiesInventoryStub();
        var spelersInventoryStub = new SpelersInventoryStub();
        var maakEenMatchVoorbereiding = new MaakEenMatchvoorbereiding(new MaakEenMatchvoorbeidingAIStub());
        var selectie = new Selectie(positiesInventoryStub.getPosities433(), spelersInventoryStub.getSpelers());

        // Call the method to create MatchVoorbereiding
        Matchvoorbereiding matchVoorbereiding = maakEenMatchVoorbereiding.maken(
                selectie,
                aantalMatchDelen,
                matchdeelTijdInMinuten,
                validationMaxTijdVerschilAllowed);

        // Assert that the result is not null and should not throw any exceptions
        assertNotNull(matchVoorbereiding, "MatchVoorbereiding should not be null");

        printPlayers(matchVoorbereiding);
    }

    private void printPlayers(Matchvoorbereiding matchVoorbereiding) {
        var deelIndex = 1;
        for (MatchDeel matchDeel : matchVoorbereiding.matchDelen()) {
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
