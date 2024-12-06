package timaar.tiimspot.controller.matchvoorbereiding.dto.response;

import timaar.tiiimspot.domain.Match;

import java.util.UUID;

public record MatchResponseDto(UUID id, MatchResponseDto matchResponseDto) {

    public MatchResponseDto(Match match) {
        this(match.id(), transform(match));
    }

    private static MatchResponseDto transform(Match match) {
        // Todo transform logic
        return new MatchResponseDto(match);
    }
}
