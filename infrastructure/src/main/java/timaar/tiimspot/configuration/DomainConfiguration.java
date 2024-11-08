package timaar.tiimspot.configuration;

import ddd.DomainService;
import ddd.Stub;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import timaar.tiiimspot.domain.Match;
import timaar.tiiimspot.spi.stubs.MaakEenMatchvoorbeidingAIStub;
import timaar.tiiimspot.spi.stubs.MatchvoorbereidingInventoryStub;
import timaar.tiiimspot.spi.stubs.PositiesInventoryStub;
import timaar.tiiimspot.spi.stubs.SpelersInventoryStub;

@Configuration
@ComponentScan(
        basePackageClasses = {Match.class},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                DomainService.class,
                Stub.class
        })},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                PositiesInventoryStub.class,
                SpelersInventoryStub.class,
                MaakEenMatchvoorbeidingAIStub.class,
                MatchvoorbereidingInventoryStub.class
        })})
public class DomainConfiguration {
}
