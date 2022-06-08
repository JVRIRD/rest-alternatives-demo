package world.inetum.realdolmen.ratings.model;

import java.time.LocalDateTime;

public record Comment(String message, String user, LocalDateTime time) {
}
