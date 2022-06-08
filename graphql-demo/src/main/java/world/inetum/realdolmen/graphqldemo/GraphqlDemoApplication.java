package world.inetum.realdolmen.graphqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import world.inetum.realdolmen.graphqldemo.mapper.GrpcMapper;

@SpringBootApplication
public class GraphqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlDemoApplication.class, args);
    }

    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8080").build();
    }
}
