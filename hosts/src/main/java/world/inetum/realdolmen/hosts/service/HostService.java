package world.inetum.realdolmen.hosts.service;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import world.inetum.realdolmen.grpc.Host;
import world.inetum.realdolmen.grpc.HostRequest;
import world.inetum.realdolmen.grpc.HostServiceGrpc.HostServiceImplBase;
import world.inetum.realdolmen.grpc.HostsReply;
import world.inetum.realdolmen.hosts.mapper.GrpcMapper;
import world.inetum.realdolmen.hosts.repository.HostRepository;

import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class HostService extends HostServiceImplBase {

    private final HostRepository repository;
    private final GrpcMapper mapper;

    @Override
    public void getHosts(Empty request, StreamObserver<HostsReply> responseObserver) {
        HostsReply reply = HostsReply.newBuilder().addAllHosts(mapper.internalToGrpc(repository.findAll())).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getHost(HostRequest request, StreamObserver<Host> responseObserver) {
        Optional<world.inetum.realdolmen.hosts.model.Host> host = repository.findById(request.getId());

        host.ifPresent(h -> responseObserver.onNext(mapper.InternalToGrpc(h)));
        responseObserver.onCompleted();
    }
}
