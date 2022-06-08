package world.inetum.realdolmen.hosts.mapper;

import org.mapstruct.Mapper;
import world.inetum.realdolmen.hosts.model.Host;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrpcMapper {
    List<world.inetum.realdolmen.grpc.Host> internalToGrpc(List<Host> hosts);

    world.inetum.realdolmen.grpc.Host InternalToGrpc(Host host);
}
