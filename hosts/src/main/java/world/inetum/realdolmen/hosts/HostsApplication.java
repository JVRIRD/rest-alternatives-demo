package world.inetum.realdolmen.hosts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "world.inetum.realdolmen.hosts.repository")
public class HostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostsApplication.class, args);
	}

}
