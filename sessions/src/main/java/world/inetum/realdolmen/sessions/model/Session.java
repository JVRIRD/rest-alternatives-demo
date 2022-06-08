package world.inetum.realdolmen.sessions.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Session {
    @Id
    private Integer id;
    private String title;
    private String description;
}
