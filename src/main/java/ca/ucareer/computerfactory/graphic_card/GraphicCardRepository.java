package ca.ucareer.computerfactory.graphic_card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicCardRepository extends JpaRepository<GraphicCard, Integer> {

        }