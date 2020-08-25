package ca.ucareer.computerfactory.graphic_card;

import org.graalvm.compiler.graph.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphicService {
    @Autowired
    GraphicRepository graphicRepository;

    //Retrieve the list of graphics
    List<Graphic> getGraphics(){
        return graphicRepository.findAll();
    }

    //Retrieve the graphic with ID
    Graphic retrieveGraphic(int id){
        return graphicRepository.findById(id).orElse(null);
    }

    //Create a graphic
    Graphic createGraphic(Graphic graphicBody){
        Graphic savedGraphic = new Graphic();
        savedGraphic.setLabel(graphicBody.getLabel());
        savedGraphic.setPrice(graphicBody.getPrice());
        savedGraphic.setBrand(graphicBody.getBrand());
        return savedGraphic;
    }

    //Update a graphic with ID
    Graphic updateGraphic(int id, Graphic graphicBody){
        Graphic savedGraphic = graphicRepository.findById(id).orElse(null);
        if (savedGraphic != null){
            savedGraphic.setLabel(graphicBody.getLabel());
            savedGraphic.setPrice(graphicBody.getPrice());
            savedGraphic.setBrand(graphicBody.getBrand());
            return savedGraphic;
        }else{
            return null;
        }
    }

    //Delete a graphic with ID
    boolean deleteGraphic(int id){
        Graphic savedGraphic = graphicRepository.findById(id).orElse(null);
        if (savedGraphic != null){
            return true;
        }else{
            return false;
        }
    }
}
