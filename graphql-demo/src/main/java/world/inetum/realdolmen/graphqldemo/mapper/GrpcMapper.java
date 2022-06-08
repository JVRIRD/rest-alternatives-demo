package world.inetum.realdolmen.graphqldemo.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import world.inetum.realdolmen.graphqldemo.model.Host;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface GrpcMapper {
    List<Host> grpcHostsToInternalHosts(List<world.inetum.realdolmen.grpc.Host> hosts);

    Host grpcHostToInternalHost(world.inetum.realdolmen.grpc.Host host);
}
