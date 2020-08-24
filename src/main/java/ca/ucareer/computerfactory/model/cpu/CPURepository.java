package ca.ucareer.computerfactory.model.cpu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CPURepository extends JpaRepository<CPU, Integer> {

    public CPU findCPUById(Integer Id);

    @Query("select id from CPU")
    public List<Integer> listAllId();

    public void deleteById(Integer Id);

}
