package ca.ucareer.computerfactory.cpu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Place to write query.
@Repository
public interface CPURepository extends JpaRepository<CPU, Integer>{
    CPU findCPUById(int id);
}