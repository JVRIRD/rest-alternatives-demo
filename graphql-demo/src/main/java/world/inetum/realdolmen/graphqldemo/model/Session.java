package world.inetum.realdolmen.graphqldemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Session {
    private Long id;
    private String title;
    private String description;
    private List<Host> hosts;
}
