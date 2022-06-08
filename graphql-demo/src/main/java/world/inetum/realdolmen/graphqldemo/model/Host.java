package world.inetum.realdolmen.graphqldemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Host {
    private Long id;
    private String firstName;
    private String lastName;
    private String function;
}
