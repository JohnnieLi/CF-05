package ca.ucareer.computerfactory.computer;

import ca.ucareer.computerfactory.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ComputerController {
    @Autowired
    ComputerService computerService;

    //List
    @GetMapping("/computers")
    public ResponseEntity<ResponseBody> list(){
        List<Computer> computerBody = computerService.getComputers();
        ResponseBody responseBody = new ResponseBody("Retrieved Successfully", computerBody, null);
        return ResponseEntity.ok(responseBody);
    }

    //Retrieve
    @GetMapping("/computers/{id]")
    public ResponseEntity<ResponseBody> retrieveComputers(@PathVariable int id){
        Computer computerBody = computerService.receiveComputers(id);
        ResponseBody responseBody = new ResponseBody("Retrieved Successfully", computerBody, null);
        return ResponseEntity.ok(responseBody);
    }

    //Create
    @PostMapping("/computers")
    public ResponseEntity<ResponseBody> createComputers(@RequestBody Computer computerbody){
        Computer savedComputer = computerService.createComputers(computerbody);
        ResponseBody responseBody = new ResponseBody("Created Successfully", computerbody, null);
        return ResponseEntity.ok(responseBody);
    }

    //Update
    @PostMapping("/computers/{id}")
    public ResponseEntity<ResponseBody> UpdateComputers(@RequestBody Computer computerbody, @PathVariable int id){
        Computer savedComputer = computerService.updateComputers(computerbody, id);
        ResponseBody responseBody = new ResponseBody("Updated Successfully", computerbody, null);
        return ResponseEntity.ok(responseBody);
    }

    //Delete
    @DeleteMapping("/computers/{id}")
    public ResponseEntity<ResponseBody> DeleteComputers( @PathVariable int id){
        boolean foundComputer = computerService.deleteComputers(id);
        if (foundComputer) {
            ResponseBody responseBody = new ResponseBody("Deleted Successfully", null, null);
            return ResponseEntity.ok(responseBody);
        }else{
            ResponseBody responseBody = new ResponseBody("No such a computer found", null, null);
            return ResponseEntity.ok(responseBody);
        }
    }

}
