package ca.ucareer.computerfactory.memory_card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryCardRepository  extends JpaRepository<MemoryCard, Integer> {
}
