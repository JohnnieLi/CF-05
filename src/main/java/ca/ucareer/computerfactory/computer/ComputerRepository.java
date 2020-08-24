package ca.ucareer.computerfactory.computer;

import ca.ucareer.computerfactory.cpu.CPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    Computer findComputerByid(int id);
}
