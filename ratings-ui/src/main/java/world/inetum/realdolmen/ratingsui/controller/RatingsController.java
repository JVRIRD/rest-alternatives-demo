package world.inetum.realdolmen.ratingsui.controller;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import world.inetum.realdolmen.ratingsui.model.Rating;

@RestController
public class RatingsController {
    private final RSocketRequester rSocketRequester;

    public RatingsController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }


    @PostMapping(value = "/api/ratings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Publisher<Rating> addRating(@RequestBody Rating rating) {
        return rSocketRequester
                .route("add-rating")
                .data(rating)
                .retrieveMono(Rating.class);
    }

    @GetMapping("/api/ratings/{sessionId}")
    public Mono<Rating> requestResponse(@PathVariable("sessionId") String sessionId) {
        return rSocketRequester
                .route("ratings")
                .data(sessionId)
                .retrieveMono(Rating.class);
    }

}
