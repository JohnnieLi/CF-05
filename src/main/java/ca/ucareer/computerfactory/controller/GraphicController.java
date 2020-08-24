package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.model.graphic.GraphicCard;
import ca.ucareer.computerfactory.model.graphic.GraphicService;
import ca.ucareer.computerfactory.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GraphicController {

    @Autowired
    GraphicService graphicService;

    @GetMapping("/graphiccards")
    public ResponseEntity<ResponseBody> listGraphic(){
        List<GraphicCard> listGraphic = graphicService.listGraphic();
        ResponseBody<List> responseBody = new ResponseBody(listGraphic,
                "get lists", null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("graphiccards/{id}")
    public ResponseEntity<ResponseBody> retrieveGraphic(@PathVariable("id") Integer id){
        ResponseBody<GraphicCard> responseBody = new ResponseBody(graphicService.retrieve(id), "get it", null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("graphiccards")
    public ResponseEntity<ResponseBody> createGraphic(@RequestBody GraphicCard newGraphic){
        ResponseBody<GraphicCard> requestBody = new ResponseBody(graphicService.create(newGraphic),
                "create one", null);
        return ResponseEntity.ok(requestBody);
    }

    @PostMapping("graphiccards/{id}")
    public ResponseEntity<ResponseBody> updateGraphic(@RequestBody GraphicCard updatedGraphic,
                                                      @PathVariable("id") Integer id){
        updatedGraphic.setId(id);
        ResponseBody<GraphicCard> responseBody = new ResponseBody(graphicService.updateGraphic(updatedGraphic),
                "update it", null);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("graphiccards/{id}")
    public ResponseEntity<ResponseBody> deleteGraphic(@PathVariable("id") Integer id){
        ResponseBody<GraphicCard> responseBody = new ResponseBody(graphicService.deleteGraphic(id),
                "delete it", null);
        return ResponseEntity.ok(responseBody);
    }
}
