package world.inetum.realdolmen.ratings.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import world.inetum.realdolmen.ratings.model.Comment;

@Controller
public class CommentController {

    private final Flux<Comment> stream;
    private final Sinks.Many<Comment> sink;

    public CommentController(Flux<Comment> stream, Sinks.Many<Comment> sink) {
        this.stream = stream;
        this.sink = sink;
    }

    @MessageMapping("add-comment")
    public Mono<Void> addComment(Comment comment) {
        sink.tryEmitNext(comment);
        return Mono.empty();
    }

    @MessageMapping("live-comments")
    public Flux<Comment> liveCommentFeed() {
        return stream;
    }
}
