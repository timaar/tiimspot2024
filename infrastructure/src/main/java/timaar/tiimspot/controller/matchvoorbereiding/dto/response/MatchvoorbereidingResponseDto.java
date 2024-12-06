package timaar.tiimspot.controller.matchvoorbereiding.dto.response;

import timaar.tiiimspot.domain.Matchvoorbereiding;

public record MatchvoorbereidingResponseDto(MatchvoorbereidingResponseDto matchvoorbereidingResponseDto) {

    public MatchvoorbereidingResponseDto(Matchvoorbereiding matchvoorbereiding) {
        this(transform(matchvoorbereiding));
    }

    private static MatchvoorbereidingResponseDto transform(Matchvoorbereiding matchvoorbereiding) {
        // Todo transform logic
        return new MatchvoorbereidingResponseDto(matchvoorbereiding);
    }
}
