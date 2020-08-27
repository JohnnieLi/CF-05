package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.model.memory.MemoryCard;
import ca.ucareer.computerfactory.model.memory.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.response.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MemoryController {

    @Autowired
    MemoryService memoryService;

    @PostMapping("/memory_cards")
    public ResponseEntity<ResponseBody> createMemory(@RequestBody MemoryCard memoryCard){
        ResponseBody<MemoryCard> responseBody = new ResponseBody(memoryService.createMemory(memoryCard), "create it", null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/memory_cards")
    public ResponseEntity<ResponseBody> listMemory(){
        ResponseBody<List> responseBody = new ResponseBody(memoryService.listMemory(), "list it", null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> retrieveMemory(@PathVariable("id") Integer id){
        ResponseBody<MemoryCard> responseBody = new ResponseBody(memoryService.retrieveMemory(id), "retrieve it", null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> updateMemory(@PathVariable("id") Integer id,
                                                     @RequestBody MemoryCard memoryCard){
        memoryCard.setId(id);
        ResponseBody<MemoryCard> requestBody = new ResponseBody(memoryService.updateMemory(memoryCard), "update it", null);
        return ResponseEntity.ok(requestBody);
    }

    @DeleteMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> deleteMemory(@PathVariable("id") Integer id){
        ResponseBody<MemoryCard> responseBody = new ResponseBody(memoryService.deleteMemory(id), "deleete it", null);
        return ResponseEntity.ok(responseBody);
    }
}
