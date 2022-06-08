package world.inetum.realdolmen.ratingsui.model;

import java.time.LocalDateTime;

public record Comment(String message, String user, LocalDateTime time) {
}
