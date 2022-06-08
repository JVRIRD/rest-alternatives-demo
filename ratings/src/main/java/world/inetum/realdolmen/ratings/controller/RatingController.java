package world.inetum.realdolmen.ratings.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.inetum.realdolmen.ratings.model.Rating;
import world.inetum.realdolmen.ratings.repository.RatingRepository;

@Controller
public class RatingController {

    private final RatingRepository repository;

    public RatingController(RatingRepository repository) {
        this.repository = repository;
    }

    @MessageMapping("add-rating")
    public Mono<Rating> addRating(Rating rating) {
        return repository.save(rating);
    }

    @MessageMapping("ratings")
    public Flux<Rating> ratings(Integer sessionId) {
        return repository.findAllBySessionId(sessionId);
    }
}
