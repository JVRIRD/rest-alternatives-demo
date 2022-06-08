package world.inetum.realdolmen.ratings.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public record Rating(@Id Integer id, Integer sessionId, Integer score, String comment) implements Serializable {
}
