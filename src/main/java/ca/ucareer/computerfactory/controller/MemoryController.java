package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.core.JWT;
import ca.ucareer.computerfactory.model.memory.MemoryCard;
import ca.ucareer.computerfactory.model.memory.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.response.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class MemoryController {

    @Autowired
    MemoryService memoryService;

    @Autowired
    JWT jwt;

    @PostMapping("/memory_cards")
    public ResponseEntity<ResponseBody> createMemory(
            @RequestHeader("token") String token,
            @RequestBody MemoryCard memoryCard){
        try{
            String userId = jwt.verifyToken(token);
            ResponseBody<MemoryCard> responseBody =
                    new ResponseBody(memoryService.createMemory(memoryCard, userId), "create it token", null);
            return ResponseEntity.ok(responseBody);
        }
        catch(Exception e){
            ResponseBody responseBody =
                    new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @GetMapping("/memory_cards")
    public ResponseEntity<ResponseBody> listMemory(@RequestHeader("token") String token){
        try{
            String userId = jwt.verifyToken(token);
            if(userId != null){
                ResponseBody<List> responseBody = new ResponseBody(memoryService.listMemory(), "list it", null);
                return ResponseEntity.ok(responseBody);
            }
            else return null;
        }
        catch(Exception e){
            ResponseBody responseBody = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @GetMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> retrieveMemory(@PathVariable("id") Integer id,
                                                       @RequestHeader("token") String token){
        try{
            String userId = jwt.verifyToken(token);
            ResponseBody<MemoryCard> responseBody = new ResponseBody(memoryService.retrieveMemory(id), "retrieve it", null);
            return ResponseEntity.ok(responseBody);
        }
        catch(Exception e){
            ResponseBody<MemoryCard> responseBody
                    = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> updateMemory(@PathVariable("id") Integer id,
                                                     @RequestBody MemoryCard memoryCard,
                                                     @RequestHeader String token){
        try{
            String userId = jwt.verifyToken(token);
            memoryCard.setId(id);
            ResponseBody<MemoryCard> requestBody = new ResponseBody(
                    memoryService.updateMemory(memoryCard, userId), "update it", null);
            return ResponseEntity.ok(requestBody);
        }
        catch(Exception e){
            ResponseBody<MemoryCard> responseBody
                    = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }

    @DeleteMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> deleteMemory(@PathVariable("id") Integer id,
                                                     @RequestHeader String token){
        try{
            String userId = jwt.verifyToken(token);
            ResponseBody<MemoryCard> responseBody = new ResponseBody(memoryService.deleteMemory(id), "deleete it", null);
            return ResponseEntity.ok(responseBody);
        }
        catch(Exception e){
            ResponseBody<MemoryCard> responseBody
                    = new ResponseBody(null, e.getMessage(), e);
            return ResponseEntity.ok(responseBody);
        }
    }
}
