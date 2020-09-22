package ca.ucareer.computerfactory.model.graphic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GraphicService {

    @Autowired
    GraphicRepository graphicRepository;

    public GraphicCard create(GraphicCard graphicBaby, String username){

        GraphicCard savingGraphic = new GraphicCard();
        if(username != null){
            savingGraphic.setCreated_by(username);
        }
        savingGraphic.setBrand(graphicBaby.getBrand());
        savingGraphic.setLabel(graphicBaby.getLabel());
        savingGraphic.setPrice(graphicBaby.getPrice());
        return graphicRepository.save(savingGraphic);

    }

    public GraphicCard retrieve(Integer id, String username){

        return graphicRepository.findByIdAndUsername(id, username).orElse(null);
    }

    public List<GraphicCard> listGraphic(String username){
        return graphicRepository.findAllByUsername(username).orElse(null);
    }

    public GraphicCard updateGraphic(GraphicCard graphicBaby, String username){
        GraphicCard updatingGraphic =
                graphicRepository.
                        findByIdAndUsername(graphicBaby.getId(), username)
                        .orElse(null);
        if (updatingGraphic != null){
            if(username != null){
                updatingGraphic.setCreated_by(username);
            }
            if(graphicBaby.getBrand() != null){
                updatingGraphic.setBrand(graphicBaby.getBrand());
            }
            if(graphicBaby.getLabel() != null){
                updatingGraphic.setLabel(graphicBaby.getLabel());
            }
            if(graphicBaby.getPrice() != 0){
                updatingGraphic.setPrice(graphicBaby.getPrice());
            }
            return graphicRepository.save(updatingGraphic);
        }
        else return null;
    }

    public GraphicCard deleteGraphic(Integer id, String username){
        GraphicCard findGraphic =
                graphicRepository
                        .findByIdAndUsername(id, username)
                        .orElse(null);
        if(findGraphic != null){
            GraphicCard deleteGraphic = new GraphicCard(findGraphic.getId(), findGraphic.getLabel(), findGraphic.getPrice(),
                    findGraphic.getBrand(), findGraphic.getModified_at(), findGraphic.getCreated_at(),
                    findGraphic.getCreated_by());
            graphicRepository.deleteById(id);
            return deleteGraphic;
        }
        else return null;
    }
}
