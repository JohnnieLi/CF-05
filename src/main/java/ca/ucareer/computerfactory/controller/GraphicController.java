package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.core.JWT;
import ca.ucareer.computerfactory.model.graphic.GraphicCard;
import ca.ucareer.computerfactory.model.graphic.GraphicService;
import ca.ucareer.computerfactory.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class GraphicController {

    @Autowired
    GraphicService graphicService;

    @Autowired
    JWT jwt;

    @GetMapping("/graphic_cards")
    public ResponseEntity<ResponseBody> listGraphic(
            @RequestHeader("token") String token
    ){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                List<GraphicCard> listGraphic = graphicService.listGraphic(username);
                ResponseBody<List> responseBody = new ResponseBody(listGraphic,
                        "get lists", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch(Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }

    }

    @GetMapping("graphic_cards/{id}")
    public ResponseEntity<ResponseBody>
    retrieveGraphic(
            @RequestHeader("token") String token,
            @PathVariable("id") Integer id){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                ResponseBody<GraphicCard> responseBody
                        = new ResponseBody(graphicService.retrieve(id, username), "get it", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch (Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("graphic_cards")
    public ResponseEntity<ResponseBody> createGraphic(
            @RequestBody GraphicCard newGraphic,
            @RequestHeader("token") String token){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                ResponseBody<GraphicCard> responseBody
                        = new ResponseBody(
                                graphicService.create(newGraphic, username),
                        "create one", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch(Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("graphic_cards/{id}")
    public ResponseEntity<ResponseBody> updateGraphic(
            @RequestHeader("token") String token,
            @RequestBody GraphicCard updatedGraphic,
            @PathVariable("id") Integer id){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                updatedGraphic.setId(id);
                ResponseBody<GraphicCard> responseBody =
                        new ResponseBody(
                                graphicService.updateGraphic(updatedGraphic, username),
                        "update it", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch(Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }

    }

    @DeleteMapping("graphic_cards/{id}")
    public ResponseEntity<ResponseBody> deleteGraphic(
            @RequestHeader("token") String token,
            @PathVariable("id") Integer id){
        try{
            String username = jwt.verifyToken(token);
            if(username != null){
                ResponseBody<GraphicCard> responseBody =
                        new ResponseBody(graphicService.deleteGraphic(id, username),
                        "delete it", null);
                return ResponseEntity.ok(responseBody);
            }
            else{
                ResponseBody responseBody =
                        new ResponseBody(null, "no username", null);
                return ResponseEntity.ok(responseBody);
            }
        }
        catch (Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), null);
            return ResponseEntity.ok(responseBody);
        }
    }
}
