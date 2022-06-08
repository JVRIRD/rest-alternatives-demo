package world.inetum.realdolmen.ratingsui.controller;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.*;
import world.inetum.realdolmen.ratingsui.model.Comment;

@RestController
public class CommentController {
    private final RSocketRequester rSocketRequester;

    public CommentController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping(value = "/api/comments", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<Comment> feed() {
        return rSocketRequester
                .route("live-comments")
                .retrieveFlux(Comment.class);
    }

    @PostMapping(value = "/api/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Publisher<Comment> addComment(@RequestBody Comment comment) {
        return rSocketRequester
                .route("add-comment")
                .data(comment)
                .retrieveMono(Comment.class);
    }
}
