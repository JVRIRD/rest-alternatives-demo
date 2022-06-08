package world.inetum.realdolmen.sessions.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import world.inetum.realdolmen.sessions.model.Session;

public interface SessionRepository extends ReactiveCrudRepository<Session, Integer> {
}
