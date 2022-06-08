package world.inetum.realdolmen.ratingsui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    Integer id;
    Integer sessionId;
    Integer score;
    String comment;
}
