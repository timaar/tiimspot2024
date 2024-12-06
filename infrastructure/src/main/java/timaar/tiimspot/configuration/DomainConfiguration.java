package timaar.tiimspot.configuration;

import ddd.DomainService;
import ddd.Stub;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"timaar.tiiimspot"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                DomainService.class,
                Stub.class
        })},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                // disable specific stubs for now outside of testing
//                PositiesInventoryStub.class,
//                SpelersInventoryStub.class,
//                MaakEenMatchvoorbeidingAIStub.class,
//                MatchvoorbereidingInventoryStub.class
        })})
public class DomainConfiguration {
}
