package world.inetum.realdolmen.graphqldemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.inetum.realdolmen.graphqldemo.model.Host;
import world.inetum.realdolmen.graphqldemo.model.Session;
import world.inetum.realdolmen.graphqldemo.model.SessionInput;
import world.inetum.realdolmen.graphqldemo.service.HostService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SessionController {
    private final WebClient webClient;
    private final HostService hostService;

    @QueryMapping
    public Flux<Session> sessions() {
        return this.webClient
                .get()
                .uri("/sessions")
                .retrieve()
                .bodyToFlux(Session.class);
    }

    @QueryMapping
    public Mono<Session> session(@Argument("id") Long id) {
        return this.webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/sessions/{id}")
                        .build(id))
                .retrieve()
                .bodyToMono(Session.class);
    }

    @MutationMapping
    public Mono<Session> addSession(@Argument("input") SessionInput sessionInput) {
        return this.webClient
                .post()
                .uri("/sessions")
                .body(Mono.just(
                        Session.builder()
                                .title(sessionInput.getTitle())
                                .description(sessionInput.getDescription())
                                .build()),
                        Session.class)
                .retrieve()
                .bodyToMono(Session.class);
    }

    @SchemaMapping(typeName = "Session", field = "hosts")
    public Iterable<Host> getHost(Session session) {
        System.out.println("Fetching hosts for session: " + session.getId());
        return hostService.getHosts();
    }
}
