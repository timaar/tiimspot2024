package timaar.tiimspot;

import ddd.Stub;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@TestConfiguration
@ComponentScan(
        basePackages = {"timaar.tiiimspot"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Stub.class})})
public class StubConfiguration {
}
