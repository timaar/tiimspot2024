package timaar.tiiimspot.feature.implementation;

import ddd.DomainService;
import timaar.tiiimspot.domain.Match;
import timaar.tiiimspot.domain.MatchDeel;
import timaar.tiiimspot.domain.Matchvoorbereiding;
import timaar.tiiimspot.domain.Positie;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.domain.Speler;
import timaar.tiiimspot.feature.MaakEenMatchvoorbereidingFeature;
import timaar.tiiimspot.spi.stubs.PositiesInventoryStub;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DomainService
public class MaakEenMatchvoorbereiding implements MaakEenMatchvoorbereidingFeature {

    private static final List<Positie> POSITION_PRIORITY = List.of(
            PositiesInventoryStub.KEEPER,
            PositiesInventoryStub.SPITS,
            PositiesInventoryStub.AANVALLENDE_MIDDENVELDER,
            PositiesInventoryStub.VERDEDIGENDE_MIDDENVELDER,
            PositiesInventoryStub.BOX_TO_BOX_MIDDENVELDER,
            PositiesInventoryStub.LINKER_CENTRALE_VERDEDIGER,
            PositiesInventoryStub.RECHTER_CENTRALE_VERDEDIGER,
            PositiesInventoryStub.LINKERVLEUGELAANVALLER,
            PositiesInventoryStub.RECHTERVLEUGELAANVALLER,
            PositiesInventoryStub.LINKSBACK,
            PositiesInventoryStub.RECHTSBACK
    );

    @Override
    public Matchvoorbereiding maken(Selectie selectie, Integer aantalMatchDelen, Integer matchdeelTijdInMinuten, Integer validatieMaxTijdVerschilTussenMaxEnMin) {
        // Track player time spent on the field
        Map<Speler, Integer> spelerTijd = new HashMap<>();
        for (Speler speler : selectie.spelers()) {
            spelerTijd.put(speler, 0); // Initialize playing time to zero
        }

        List<MatchDeel> matchDelen = new ArrayList<>();
        HashMap<Speler, Integer> benchPlayers = new HashMap<>(); // Track bench players

        for (int deelIndex = 0; deelIndex < aantalMatchDelen; deelIndex++) {
            Map<Positie, List<Speler>> opstelling = new HashMap<>();
            Set<Speler> usedPlayers = new HashSet<>();

            // If this is not the first matchdeel, prioritize players who were on the bench
            if (deelIndex > 0) {

                benchPlayers.entrySet().stream()
                        .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Highest rating first
                        .forEach(benchPlayer -> {
                            if (!usedPlayers.contains(benchPlayer.getKey())) { // Ensure the player isn't already used

                                // Convert positions and quotering to a sorted list of entries (highest quotering first)
                                List<Map.Entry<Positie, Integer>> sortedPosities = new ArrayList<>(benchPlayer.getKey().positieQuotering().entrySet());
                                sortedPosities.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

                                // Try to add the player to the highest-rated available position
                                boolean inserted = false;
                                for (Map.Entry<Positie, Integer> entry : sortedPosities) {
                                    if (!inserted && opstelling.get(entry.getKey()) == null) { // Position is available
                                        addSpelerToOpstelling(opstelling, benchPlayer.getKey(), entry.getKey(), usedPlayers, matchdeelTijdInMinuten, spelerTijd);
                                        inserted = true;
                                    }
                                }
                            }
                        });

                for (Map.Entry<Speler, Integer> benchPlayer : benchPlayers.entrySet()) {
                    if (!usedPlayers.contains(benchPlayer.getKey())) { // Ensure the player isn't already used
                        // Omzetten naar een List van Map.Entry objecten
                        List<Map.Entry<Positie, Integer>> sortedPosities = new ArrayList<>(benchPlayer.getKey().positieQuotering().entrySet());

                        // Sorteren op basis van de waarde (quotering)
                        sortedPosities.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
                        Boolean inserted = Boolean.FALSE;

                        for (final Map.Entry<Positie, Integer> entry : sortedPosities) {
                            if (Boolean.FALSE.equals(inserted) && opstelling.get(entry.getKey()) == null) {
                                addSpelerToOpstelling(opstelling, benchPlayer.getKey(), entry.getKey(), usedPlayers, matchdeelTijdInMinuten, spelerTijd);
                                inserted = Boolean.TRUE;
                            }
                        }
                    }
                }
            }

            // Fill the required positions first
            for (Positie positie : POSITION_PRIORITY) {
                if (!selectie.posities().contains(positie) || opstelling.get(positie) != null) {
                    continue;
                }
                for (int i = 0; i < positie.aantalSpelers(); i++) {
                    // Select a player for the current position
                    Speler selectedPlayer = selectPlayerForPosition(positie, selectie.spelers(), usedPlayers, spelerTijd);
                    if (selectedPlayer != null) {
                        addSpelerToOpstelling(opstelling, selectedPlayer, positie, usedPlayers, matchdeelTijdInMinuten, spelerTijd);
                    }
                }
            }

            // Create final copies of usedPlayers and previousBenchPlayers to avoid lambda variable issues
            final Set<Speler> finalUsedPlayers = new HashSet<>(usedPlayers);

            // Add remaining players to the bank, filtering out used and previous bench players
            List<Speler> bankPlayers = selectie.spelers().stream()
                    .filter(speler -> !finalUsedPlayers.contains(speler)) // Exclude used players
                    .toList();

            if (!bankPlayers.isEmpty()) {
                opstelling.computeIfAbsent(PositiesInventoryStub.BANK, k -> new ArrayList<>()).addAll(bankPlayers);
                bankPlayers.forEach(player -> benchPlayers.merge(player, 1, Integer::sum));
            }

            // Create a MatchDeel and add it to the match preparation
            matchDelen.add(new MatchDeel(opstelling, matchdeelTijdInMinuten));
        }

        Match match = new Match(matchDelen);

        // Validate equal playtime with a maximum difference of 20 minutes
        validateEqualPlayTime(spelerTijd, match, validatieMaxTijdVerschilTussenMaxEnMin);

        return new Matchvoorbereiding(match);
    }

    private void addSpelerToOpstelling(Map<Positie, List<Speler>> opstelling, Speler selectedPlayer, Positie positie, Set<Speler> usedPlayers, Integer matchdeelTijdInMinuten, Map<Speler, Integer> spelerTijd) {
        opstelling.computeIfAbsent(positie, k -> new ArrayList<>()).add(selectedPlayer);
        usedPlayers.add(selectedPlayer);
        if (!PositiesInventoryStub.BANK.equals(positie)) {
            spelerTijd.put(selectedPlayer, spelerTijd.get(selectedPlayer) + matchdeelTijdInMinuten);
        }
    }

    private Speler selectPlayerForPosition(Positie positie,
                                           List<Speler> spelers,
                                           Set<Speler> usedPlayers,
                                           Map<Speler, Integer> spelerTijd) {
        // If selecting for the bench, pick the player with the most playing time
        if (positie.equals(PositiesInventoryStub.BANK)) {
            return spelers.stream()
                    .filter(speler -> !usedPlayers.contains(speler))
                    .findFirst()
                    .orElse(null);
        }

        // Otherwise, prioritize players with less playing time for regular positions
        int maxWeight = spelers.stream()
                .filter(speler -> speler.positieQuotering().containsKey(positie) && !usedPlayers.contains(speler))
                .map(speler -> speler.positieQuotering().get(positie))
                .max(Integer::compare)
                .orElse(0);

        return spelers.stream()
                .filter(speler -> speler.positieQuotering().containsKey(positie) && !usedPlayers.contains(speler))
                .filter(speler -> speler.positieQuotering().get(positie) >= maxWeight)
                .min(Comparator.comparingInt(spelerTijd::get))
                .orElseThrow(() -> new IllegalArgumentException("No suitable player found for position: " + positie.naam()));
    }

    private void validateEqualPlayTime(Map<Speler, Integer> spelerTijd, Integer matchdeelTijdInMinuten, Integer aantalMatchDelen, Integer validatieMaxTijdVerschilTussenMaxEnMin) {
        int totalPlayingTime = matchdeelTijdInMinuten * aantalMatchDelen;
        int averagePlayingTime = calculateAverage(spelerTijd);

        for (Map.Entry<Speler, Integer> entry : spelerTijd.entrySet()) {
            int tijd = entry.getValue();
            if (Math.abs(tijd - averagePlayingTime) > validatieMaxTijdVerschilTussenMaxEnMin) {
                throw new IllegalArgumentException("Player " + entry.getKey().naam() + " plays an unequal amount of time: " + tijd + " minutes. Average play time is: " + averagePlayingTime + " totalPlayingTime: " + totalPlayingTime);
            }
        }
    }


    private void validateEqualPlayTime(Map<Speler, Integer> spelerTijd, Match match, Integer validatieMaxTijdVerschilTussenMaxEnMin) {
        int totalPlayingTime = match.totalPlayingTime();
        int averagePlayingTime = calculateAverage(spelerTijd);

        for (Map.Entry<Speler, Integer> entry : spelerTijd.entrySet()) {
            int tijd = entry.getValue();
            if (Math.abs(tijd - averagePlayingTime) > validatieMaxTijdVerschilTussenMaxEnMin) {
                throw new IllegalArgumentException("Player " + entry.getKey().naam() + " plays an unequal amount of time: " + tijd + " minutes. Average play time is: " + averagePlayingTime + " totalPlayingTime: " + totalPlayingTime);
            }
        }
    }

    private int calculateAverage(Map<Speler, Integer> spelerTijd) {
        if (spelerTijd.isEmpty()) {
            return 0; // return 0 to avoid division by zero
        }

        // Sum up all the values
        int total = spelerTijd.values().stream().mapToInt(Integer::intValue).sum();

        // Calculate the average and round up to the nearest integer
        double average = (double) total / spelerTijd.size();
        return (int) Math.ceil(average);
    }
}