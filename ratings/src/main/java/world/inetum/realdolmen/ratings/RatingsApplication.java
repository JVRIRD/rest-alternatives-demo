package world.inetum.realdolmen.ratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Sinks;
import world.inetum.realdolmen.ratings.model.Rating;

@SpringBootApplication
public class RatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsApplication.class, args);
	}

}
