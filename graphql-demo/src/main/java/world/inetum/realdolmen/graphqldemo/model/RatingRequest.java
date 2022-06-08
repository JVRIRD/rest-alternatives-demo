package world.inetum.realdolmen.graphqldemo.model;

public record RatingRequest(Integer sessionId, Integer score, String comment) {
}
