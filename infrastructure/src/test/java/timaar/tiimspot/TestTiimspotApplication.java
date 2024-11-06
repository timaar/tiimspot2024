package timaar.tiimspot;

import org.springframework.boot.SpringApplication;

public class TestTiimspotApplication {

	public static void main(String[] args) {

        SpringApplication.from(TiimspotApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
