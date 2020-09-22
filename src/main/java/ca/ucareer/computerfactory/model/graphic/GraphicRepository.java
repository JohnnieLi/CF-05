package ca.ucareer.computerfactory.model.graphic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GraphicRepository
        extends JpaRepository<GraphicCard, Integer> {

    @Query("select g from GraphicCard g " +
            "where g.id = ?1 " +
            "and g.created_by = ?2")
    public Optional<GraphicCard> findByIdAndUsername(Integer id, String username);

    @Query("select g from GraphicCard g where g.created_by = ?1")
    public Optional<List<GraphicCard>> findAllByUsername(String username);
}
