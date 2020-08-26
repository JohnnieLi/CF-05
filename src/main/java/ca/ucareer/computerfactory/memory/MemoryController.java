package ca.ucareer.computerfactory.memory;

import ca.ucareer.computerfactory.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")

public class MemoryController {
    @Autowired
    MemoryService memoryService;
    //Get a list of memory
    @RequestMapping("memories")
    public ResponseEntity<ResponseBody> list(){
        List<Memory> memories = memoryService.list();
        ResponseBody responseBody = new ResponseBody("Retrieved all the memories", memories, null);
        return ResponseEntity.ok(responseBody);
    }

    //Get the memory with the ID
    @RequestMapping("memories/{id}")
    public ResponseEntity<ResponseBody> retrieveMemory(@PathVariable int id){
        Memory memoryBody = memoryService.retrieveMemory(id);
        ResponseBody responseBody = new ResponseBody("Retrieved a memory card with id", memoryBody, null);
        return ResponseEntity.ok(responseBody);
    }

    //Create a memory
    @PostMapping("memories")
    public ResponseEntity<ResponseBody> createMemory(@RequestBody Memory memoryBody){
        Memory savedMemory = memoryService.createMemory(memoryBody);
        ResponseBody responseBody = new ResponseBody("Created a new memory", savedMemory, null);
        return ResponseEntity.ok(responseBody);
    }

    //Update the memory with the ID
    @PostMapping("memories/{id}")
    public ResponseEntity<ResponseBody> updateMemory(@PathVariable int id, @RequestBody Memory memoryBody){
        Memory savedMemory = memoryService.updateMemory(memoryBody, id);
        ResponseBody responseBody = new ResponseBody("Updated a new memory", savedMemory, null);
        return ResponseEntity.ok(responseBody);
    }

    //Delete the memory with the ID
    @DeleteMapping("memories/{id}")
    public  ResponseEntity<ResponseBody> deleteMemory(@PathVariable int id){
        boolean foundMemory = memoryService.deleteMemory(id);
        if (foundMemory){
            ResponseBody responseBody = new ResponseBody("The memory has been deleted", null, null);
            return ResponseEntity.ok(responseBody);
        }else{
            ResponseBody responseBody = new ResponseBody("No such a memory", null, null);
            return ResponseEntity.ok(responseBody);
        }
    }
}
