package timaar.tiimspot.controller.matchvoorbereiding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import timaar.tiiimspot.spi.MatchvoorbereidingInventory;
import timaar.tiimspot.StubConfiguration;
import timaar.tiimspot.configuration.DomainConfiguration;

@WebMvcTest(MatchvoorbereidingController.class)
@Import({
        DomainConfiguration.class,
        StubConfiguration.class
})
public class MatchVoorbereidingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatchvoorbereidingInventory matchvoorbereidingInventory;


//    @TestConfiguration
//    @ComponentScan(
//            basePackageClasses = {Match.class},
//            includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Stub.class})})
//    public class StubConfiguration {
//    }
}
