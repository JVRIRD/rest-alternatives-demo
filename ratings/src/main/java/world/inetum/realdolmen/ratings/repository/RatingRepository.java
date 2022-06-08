package world.inetum.realdolmen.ratings.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import world.inetum.realdolmen.ratings.model.Rating;

public interface RatingRepository extends ReactiveCrudRepository<Rating, Integer> {
    Flux<Rating> findAllBySessionId(Integer sessionId);
}
