package world.inetum.realdolmen.ratings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import world.inetum.realdolmen.ratings.model.Comment;

@Configuration
public class RSocketStreamSender {
    @Bean
    public Sinks.Many<Comment> sink() {
        return Sinks.many().replay().latest();
    }

    @Bean
    public Flux<Comment> streamFlux(Sinks.Many<Comment> sink) {
        return sink.asFlux();
    }
}
