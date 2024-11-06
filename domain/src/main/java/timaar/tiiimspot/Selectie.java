package timaar.tiiimspot;

import java.util.List;
import java.util.Objects;

public record Selectie(List<Positie> posities, List<Speler> spelers) {
    public Selectie(List<Positie> posities, List<Speler> spelers) {

        // Validate that the inputs are not null
        Objects.requireNonNull(posities, "posities must not be null");
        Objects.requireNonNull(spelers, "spelers must not be null");

        // Validate that elements within the lists are not null
        posities.forEach(pos -> Objects.requireNonNull(pos, "Position in the list cannot be null"));
        spelers.forEach(speler -> Objects.requireNonNull(speler, "Player in the list cannot be null"));

        this.posities = posities;
        this.spelers = spelers;

        validateTooMuchPlayers();
        validateTooFewPlayers();
        validateEachPositionCanBeFilled();
    }

    void validateEachPositionCanBeFilled() {
        for (Positie positie : posities) {
            if (spelers.stream().noneMatch(speler -> speler.positieQuotering().containsKey(positie))) {
                throw new IllegalArgumentException("No players available for position: " + positie.naam());
            }
        }
    }

    void validateTooFewPlayers() {
        long totalPosities = posities.stream()
                .filter(pos -> pos.aantalSpelers() != null)
                .count();

        if (spelers.size() < totalPosities) {
            throw new IllegalArgumentException("Not enough players in the selection. Minimum required: " + totalPosities);
        }
    }

    void validateTooMuchPlayers() {
        int totalRequiredPlayers = posities.stream()
                .filter(pos -> pos.aantalSpelers() != null) // Exclude positions without a specified player count
                .mapToInt(Positie::aantalSpelers)
                .sum();

        if (spelers.size() > totalRequiredPlayers) {
            throw new IllegalArgumentException("Too many players in the selection. Maximum allowed: " + totalRequiredPlayers);
        }
    }
}
