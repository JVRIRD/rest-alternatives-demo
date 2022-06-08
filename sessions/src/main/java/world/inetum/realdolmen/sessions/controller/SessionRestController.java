package world.inetum.realdolmen.sessions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.inetum.realdolmen.sessions.model.Session;
import world.inetum.realdolmen.sessions.repository.SessionRepository;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class SessionRestController {
    private final SessionRepository repository;

    @GetMapping("/sessions")
    Flux<Session> getSessions() {
        return repository.findAll();
    }

    @GetMapping("/sessions/{id}")
    Mono<Session> getSessionById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @PostMapping("/sessions")
    Mono<Session> addSession(@RequestBody Session session) {
        return repository.save(session);
    }
}
