package ca.ucareer.computerfactory.graphic_card;

import ca.ucareer.computerfactory.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GraphicCardController {

    @Autowired
    GraphicCardService graphicCardService;

    @GetMapping("/graphic_cards")
    public ResponseEntity<ResponseBody> list(){
        List<GraphicCard> graphicCardList = graphicCardService.list();
        String finalMessage = "Graphic card list has been obtained";
        ResponseBody responseBody = new ResponseBody<>(graphicCardList, finalMessage,null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/graphic_cards/{id}")
    public ResponseEntity<ResponseBody> getById(@PathVariable int id){
        GraphicCard graphicCardFound = graphicCardService.find(id);
        String finalMessage = "";
        if (graphicCardFound != null){
            finalMessage = "Graphic Card with id = " + id + " has been found.";
        }
        else{
            finalMessage = "Graphic card with id = " + id + " does not exist.";
        }
        ResponseBody responseBody = new ResponseBody<>(graphicCardFound,finalMessage,null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/graphic_cards")
    public ResponseEntity<ResponseBody>creatGraphicCard (@RequestBody GraphicCard graphicCardBody){
        GraphicCard graphicCardCreated = graphicCardService.create(graphicCardBody);
        String finalMessage = "New graphic card has been created.";
        ResponseBody responseBody = new ResponseBody<>(graphicCardCreated, finalMessage,null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/graphic_cards/{id}")
    public ResponseEntity<ResponseBody>updateGraphicCard (@PathVariable int id, @RequestBody GraphicCard graphicCardBody){
        GraphicCard graphicCardFound = graphicCardService.find(id);
        String finalMessage  = "";
        if (graphicCardFound != null){
            graphicCardFound = graphicCardService.update(id, graphicCardBody);
            finalMessage = "Graphic Card with id = " + id + " has been updated.";
        }
        else {
            finalMessage = "Graphic card with id = " + id + " does not exist.";
        }

        ResponseBody responseBody = new ResponseBody<>(graphicCardFound, finalMessage,null);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("//graphic_cards/{id}")
    public ResponseEntity<ResponseBody> deletebyId (@PathVariable int id){
        GraphicCard graphicCardToDelete = graphicCardService.find(id);
        String finalMessage = "";
        if (graphicCardToDelete != null){
            graphicCardService.delete(id);
            finalMessage = "Graphic Card with id = " + id + " has been deleted";

        }
        else {
            finalMessage = "Graphic Card with id = " + id + " does not exist.";
        }
        ResponseBody responseBody = new ResponseBody<>(graphicCardService, finalMessage, null);
        return ResponseEntity.ok(responseBody);

    }


}
