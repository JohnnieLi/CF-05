package ca.ucareer.computerfactory.model.graphic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicRepository extends JpaRepository<GraphicCard, Integer> {
}
