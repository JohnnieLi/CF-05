package ca.ucareer.computerfactory.computer;

import ca.ucareer.computerfactory.ResponseBody;
import ca.ucareer.computerfactory.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ComputerController {


    @Autowired
    ComputerService service;

    //list
    @GetMapping("/computers")
    public ResponseEntity<ResponseBody> list() {
        List<Computer> foundList = service.listComputers();
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<List<Computer>>(foundList, "", null);
        return ResponseEntity.ok(responseBody);
 //       return ResponseEntity.status(400).body(responseBody);
    }

    //retrieve
    @GetMapping("/computers/{id}")
    public ResponseEntity<ResponseBody> getOne(@PathVariable Integer id) {
        Computer foundOne = service.getComputerById(id);
        List<User> users = foundOne.getUsers();
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<Computer>(foundOne, "", null);
        return ResponseEntity.ok(responseBody);
    }

    //create
    @PostMapping("/computers")
    public ResponseEntity<ResponseBody> create(@RequestBody Computer body) {
        Computer foundOne = service.createComputer(body);
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<Computer>(foundOne, "", null);
        return ResponseEntity.status(200).body(responseBody);
    }
}
