package world.inetum.realdolmen.ratingsui.controller;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import world.inetum.realdolmen.ratingsui.model.Comment;
import world.inetum.realdolmen.ratingsui.model.Rating;

@Controller
public class ViewController {

    private final RSocketRequester rSocketRequester;

    public ViewController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping("/live")
    public String showAll(Model model) {
        Flux<Comment> commentFlux = rSocketRequester
                .route("live-comments")
                .retrieveFlux(Comment.class);

        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(commentFlux, 1);
        model.addAttribute("comments", reactiveDataDrivenMode);

        return "comments/index";
    }

    @GetMapping("/ratings/{sessionId}")
    public String showAll(Model model, @PathVariable("sessionId") Integer sessionId) {
        Flux<Rating> ratingFlux = rSocketRequester
                .route("ratings")
                .data(sessionId)
                .retrieveFlux(Rating.class);

        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(ratingFlux, 1);
        model.addAttribute("ratings", reactiveDataDrivenMode);

        return "ratings/index";
    }
}
