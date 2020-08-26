package ca.ucareer.computerfactory.graphic_card;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphicCardService {

    @Autowired
    GraphicCardRepository graphicCardRepository;

    List<GraphicCard> list(){
        return graphicCardRepository.findAll();
    }

    GraphicCard find(int id){
        return graphicCardRepository.findById(id).orElse(null);
    }

    GraphicCard create (GraphicCard graphicCardBody){
        GraphicCard graphicCardPosted = new GraphicCard();

        if (graphicCardBody != null){
            graphicCardPosted.setLabel(graphicCardBody.getLabel());
            graphicCardPosted.setPrice(graphicCardBody.getPrice());
            graphicCardPosted.setBrand(graphicCardBody.getBrand());
        }
        return graphicCardRepository.save(graphicCardPosted);
    }

    GraphicCard update(int id, GraphicCard graphicCardBody){
        GraphicCard graphicCardUpdated = graphicCardRepository.findById(id).orElse(null);

        if (graphicCardBody.getLabel() != null){
            graphicCardUpdated.setLabel(graphicCardBody.getLabel());
        }
        if (graphicCardBody.getBrand() != null){
            graphicCardUpdated.setBrand(graphicCardBody.getBrand());
        }
        if (graphicCardBody.getPrice() != null){
            graphicCardUpdated.setPrice(graphicCardBody.getPrice());
        }


        return graphicCardRepository.save(graphicCardUpdated);
    }

    void delete (int id) {
        if (graphicCardRepository.findById(id) != null){
            graphicCardRepository.deleteById(id);
        }
    }
}
