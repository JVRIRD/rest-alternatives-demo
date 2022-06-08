package world.inetum.realdolmen.graphqldemo.service;

import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import world.inetum.realdolmen.graphqldemo.model.Host;
import world.inetum.realdolmen.graphqldemo.mapper.GrpcMapper;
import world.inetum.realdolmen.grpc.HostRequest;
import world.inetum.realdolmen.grpc.HostServiceGrpc;
import world.inetum.realdolmen.grpc.HostsReply;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostService {

    private final GrpcMapper grpcMapper;

    @GrpcClient("hostService")
    private HostServiceGrpc.HostServiceBlockingStub hostServiceStub;

    public List<Host> getHosts() {
        HostsReply hostsReply = hostServiceStub.getHosts(Empty.newBuilder().build());

        return grpcMapper.grpcHostsToInternalHosts(hostsReply.getHostsList());
    }

    public Host getHost(Integer id) {
        world.inetum.realdolmen.grpc.Host host = hostServiceStub.getHost(HostRequest.newBuilder().setId(id).build());

        return grpcMapper.grpcHostToInternalHost(host);
    }
}
