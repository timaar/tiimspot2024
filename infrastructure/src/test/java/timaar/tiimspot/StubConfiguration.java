package timaar.tiimspot;

import ddd.Stub;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import timaar.tiiimspot.domain.Match;

@TestConfiguration
@ComponentScan(
        basePackageClasses = {Match.class},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Stub.class})})
public class StubConfiguration {
}
