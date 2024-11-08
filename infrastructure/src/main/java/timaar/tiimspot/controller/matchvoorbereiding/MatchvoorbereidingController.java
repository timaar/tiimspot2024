package timaar.tiimspot.controller.matchvoorbereiding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.feature.MaakEenMatchvoorbereidingFeature;
import timaar.tiiimspot.spi.MatchvoorbereidingInventory;
import timaar.tiiimspot.spi.stubs.PositiesInventoryStub;
import timaar.tiiimspot.spi.stubs.SpelersInventoryStub;
import timaar.tiimspot.controller.matchvoorbereiding.dto.request.MatchVoorbereidingRequestDto;
import timaar.tiimspot.controller.matchvoorbereiding.dto.response.MatchVoorbereidingResponseDto;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/match")
public class MatchvoorbereidingController {

    private MaakEenMatchvoorbereidingFeature maakEenMatchVoorbereiding;
    private MatchvoorbereidingInventory matchvoorbereidingInventory;

    @PostMapping("/maakEenVoorbereiding")
    public ResponseEntity<MatchVoorbereidingResponseDto> maakMatchVoorbereiding(@RequestBody MatchVoorbereidingRequestDto matchVoorbereidingRequestDto) {
        // TODO transform/map requesdto to selectie
        var matchVoorbereiding = maakEenMatchVoorbereiding.maken(new Selectie(new PositiesInventoryStub().getPosities433(), new SpelersInventoryStub().getSpelers()));
        return created(fromMethodCall(on(this.getClass()).getMatchVoorbereiding(matchVoorbereiding.id())).build().toUri())
                .body(new MatchVoorbereidingResponseDto(matchVoorbereiding));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchVoorbereidingResponseDto> getMatchVoorbereiding(@PathVariable UUID id) {
        return ok(new MatchVoorbereidingResponseDto(matchvoorbereidingInventory.getById(id)));
    }
}
