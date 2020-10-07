package ca.ucareer.computerfactory.Head;

import ca.ucareer.computerfactory.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class HeadController {

    @Autowired
    HeadService headService;

    @GetMapping("/heads")
    public ResponseEntity<ResponseBody> getHeadList() {
        List<Head> HeadList = headService.list();
        String finalMessage = "Head list has been obtained";
        ResponseBody responseBody = new ResponseBody<>(HeadList, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/heads/{id}")
    public ResponseEntity<ResponseBody> getHeadById(@PathVariable int id) {
        Head HeadFound = headService.findById(id);
        String finalMessage = "";
        if (HeadFound != null){
            finalMessage = "Head with id = " + id + " has been found.";
        }
        else {
            finalMessage = "Head with id = " + id + " does not exist.";
        }
        ResponseBody responseBody = new ResponseBody<>(HeadFound, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/heads")
    public ResponseEntity<ResponseBody>creatHead(@RequestBody Head HeadBody){
        Head HeadCreated = headService.create(HeadBody);
        String finalMessage = "New Head has been created.";
        ResponseBody responseBody = new ResponseBody<>(HeadCreated, finalMessage,null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/heads/{id}")
    public ResponseEntity<ResponseBody> updateHeadById(@PathVariable int id, @RequestBody Head HeadBody){
        Head HeadToUpdate = headService.findById(id);
        String finalMessage = "";
        if (HeadToUpdate != null){
            HeadToUpdate = headService.update(id, HeadBody);
            finalMessage = "Head with id = " + id + " has been updated.";

        }
        else {
            finalMessage = "Head with id = " + id + " does not exist.";
        }
        ResponseBody responseBody = new ResponseBody<>(HeadToUpdate, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("heads/{id}")
    public ResponseEntity<ResponseBody> deleteHeadById(@PathVariable int id){
        Head HeadToDelete = headService.findById(id);
        String finalMessage = "";
        if (HeadToDelete != null){
            headService.delete(id);
            finalMessage = "Head with id = " + id + " has been deleted.";

        }
        else {
            finalMessage = "Head with id = " + id + " does not exist.";
        }
        ResponseBody responseBody = new ResponseBody<>(HeadToDelete, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

}


