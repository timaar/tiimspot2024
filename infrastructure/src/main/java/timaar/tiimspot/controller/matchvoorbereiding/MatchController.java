package timaar.tiimspot.controller.matchvoorbereiding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timaar.tiiimspot.domain.Match;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.feature.MaakEenMatchvoorbereidingFeature;
import timaar.tiiimspot.spi.MaakEenMatchvoorbeidingAI;
import timaar.tiiimspot.spi.MatchInventory;
import timaar.tiiimspot.spi.stubs.PositiesInventoryStub;
import timaar.tiiimspot.spi.stubs.SpelersInventoryStub;
import timaar.tiimspot.controller.matchvoorbereiding.dto.request.MatchRequestDto;
import timaar.tiimspot.controller.matchvoorbereiding.dto.response.MatchResponseDto;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/match")
public class MatchController {

    private MaakEenMatchvoorbereidingFeature maakEenMatchVoorbereiding;
    private MaakEenMatchvoorbeidingAI maakEenMatchvoorbereidingAI;
    private MatchInventory matchInventory;

    @PostMapping("/maakEenVoorbereiding")
    public ResponseEntity<MatchResponseDto> maakMatchVoorbereiding(@RequestBody MatchRequestDto matchRequestDto) {
        // TODO transform/map requesdto to selectie
        var matchVoorbereiding = maakEenMatchVoorbereiding.maken(new Selectie(new PositiesInventoryStub().getPosities433(), new SpelersInventoryStub().getSpelers()));
        var matchvoorbereidingAI = maakEenMatchvoorbereidingAI.maken(new Selectie(new PositiesInventoryStub().getPosities433(), new SpelersInventoryStub().getSpelers()));
        var match = new Match(List.of(matchVoorbereiding, matchvoorbereidingAI));

        return created(fromMethodCall(on(this.getClass())
                .getMatch(match.id())).build().toUri())
                .body(new MatchResponseDto(match));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDto> getMatch(@PathVariable UUID id) {
        return ok(new MatchResponseDto(matchInventory.getById(id)));
    }
}
