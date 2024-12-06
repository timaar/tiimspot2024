package timaar.tiimspot.controller.matchvoorbereiding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timaar.tiiimspot.domain.Selectie;
import timaar.tiiimspot.feature.MaakEenMatchvoorbereidingFeature;
import timaar.tiiimspot.spi.MatchvoorbereidingInventory;
import timaar.tiiimspot.spi.stubs.PositieInventoryStub;
import timaar.tiiimspot.spi.stubs.SpelerInventoryStub;
import timaar.tiimspot.controller.matchvoorbereiding.dto.request.GenereerMatchvoorbereidingenRequestDto;
import timaar.tiimspot.controller.matchvoorbereiding.dto.response.GenereerMatchvoorbereidingenResponseDto;
import timaar.tiimspot.controller.matchvoorbereiding.dto.response.MatchvoorbereidingResponseDto;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/matchvoorbereiding")
public class MatchVoorbereidingController {

    private MaakEenMatchvoorbereidingFeature maakEenMatchVoorbereiding;
    private MatchvoorbereidingInventory matchVoorbereidingInventory;

    public MatchVoorbereidingController(MaakEenMatchvoorbereidingFeature maakEenMatchVoorbereiding,
                                        MatchvoorbereidingInventory matchVoorbereidingInventory) {
        this.maakEenMatchVoorbereiding = maakEenMatchVoorbereiding;
        this.matchVoorbereidingInventory = matchVoorbereidingInventory;
    }

    @GetMapping("/genereerMatchVoorbereidingen")
    public ResponseEntity<GenereerMatchvoorbereidingenResponseDto> genereer(@RequestBody GenereerMatchvoorbereidingenRequestDto genereerMatchVoorbereidingenRequestDto) {
        // TODO transform/map requesdto to selectie
        var matchVoorbereiding = new MatchvoorbereidingResponseDto(maakEenMatchVoorbereiding.maken(new Selectie(new PositieInventoryStub().getPosities433(), new SpelerInventoryStub().getSpelers())));
        var matchvoorbereidingAI = new MatchvoorbereidingResponseDto(maakEenMatchVoorbereiding.makenByAI(new Selectie(new PositieInventoryStub().getPosities433(), new SpelerInventoryStub().getSpelers())));

        return ok(
                new GenereerMatchvoorbereidingenResponseDto(List.of(matchVoorbereiding, matchvoorbereidingAI)));
    }
}
