package world.inetum.realdolmen.hosts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.inetum.realdolmen.hosts.model.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer> {
}
