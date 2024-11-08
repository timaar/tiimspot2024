package timaar.tiimspot.controller.matchvoorbereiding.dto.response;

import timaar.tiiimspot.domain.Matchvoorbereiding;

import java.util.UUID;

public record MatchVoorbereidingResponseDto(UUID id, MatchResponseDto matchResponseDto) {
    public MatchVoorbereidingResponseDto(Matchvoorbereiding matchvoorbereiding) {
        this(matchvoorbereiding.id(), transform(matchvoorbereiding));
    }

    private static MatchResponseDto transform(Matchvoorbereiding matchvoorbereiding) {
        // Todo transform logic
        return new MatchResponseDto();
    }
}
