package ca.ucareer.computerfactory.cpu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPURepository extends JpaRepository<CPU, Integer> {

    CPU findCPUByLabel(String Label);

}


