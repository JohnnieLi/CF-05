package ca.ucareer.computerfactory.graphic_card;

import ca.ucareer.computerfactory.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GraphicController {
    @Autowired
    GraphicService graphicService;

    //Get a list of Graphics
    @GetMapping("/graphics")
    public ResponseEntity<ResponseBody> list(){
        List<Graphic> graphic = graphicService.getGraphics();
        ResponseBody responseBody = new ResponseBody("Retrieved a list of graphic cards", graphic, null);
        return ResponseEntity.ok(responseBody);
    }

    //Get the graphic with ID
    @GetMapping("/graphics/{id}")
    public ResponseEntity<ResponseBody> getGraphic(@PathVariable int id){
        Graphic graphic = graphicService.retrieveGraphic(id);
        ResponseBody responseBody = new ResponseBody("Retrieved graphic with id", graphic, null );
        return ResponseEntity.ok(responseBody);
    }

    //Create a graphic
    @PostMapping("/graphics")
    public ResponseEntity<ResponseBody> createGraphic(@RequestBody Graphic graphicBody){
        Graphic graphic = graphicService.createGraphic(graphicBody);
        ResponseBody responseBody = new ResponseBody("Created a new graphic", graphic, null);
        return ResponseEntity.ok(responseBody);
    }

    //Update the graphic with ID
    @PostMapping("graphics/{id}")
    public ResponseEntity<ResponseBody> updateGraphic(@RequestBody Graphic graphicBody, @PathVariable int id){
        Graphic graphic = graphicService.updateGraphic(id, graphicBody);
        ResponseBody responseBody = new ResponseBody("Updated the graphic", graphic, null);
        return ResponseEntity.ok(responseBody);
    }

    //Delete the graphic with ID
    @DeleteMapping("graphics/{id}")
    public ResponseEntity<ResponseBody> deleteGraphic(@PathVariable int id){
        boolean foundGraphic = graphicService.deleteGraphic(id);
        if (foundGraphic){
            ResponseBody responseBody = new ResponseBody("Deleted the graphic", foundGraphic, null);
            return ResponseEntity.ok(responseBody);
        }else{
            ResponseBody responseBody = new ResponseBody("No such a graphic", foundGraphic, null);
            return ResponseEntity.ok(responseBody);
        }
    }
}
