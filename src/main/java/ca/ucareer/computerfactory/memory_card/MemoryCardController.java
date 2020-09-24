package ca.ucareer.computerfactory.memory_card;

import ca.ucareer.computerfactory.ResponseBody;
import ca.ucareer.computerfactory.computer.Computer;
import ca.ucareer.computerfactory.computer.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MemoryCardController {
    @Autowired
    MemoryCardService service;

    //list
    @GetMapping("/memory_cards")
    public ResponseEntity<ResponseBody> list() {
        List<MemoryCard> foundList = service.listMemoryCards();
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<List<MemoryCard>>(foundList, "", null);
        return ResponseEntity.ok(responseBody);
    }

    //retrieve
    @GetMapping("/memory_cards/{id}")
    public ResponseEntity<ResponseBody> getOne(@PathVariable Integer id) {
        MemoryCard foundOne = service.getMemoryCardById(id);
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<MemoryCard>(foundOne, "", null);
        return ResponseEntity.ok(responseBody);
    }

    //create
    @PostMapping("/memory_cards")
    public ResponseEntity<ResponseBody> create(@RequestBody MemoryCard body) {
        MemoryCard foundOne = service.createMemoryCard(body);
        ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<MemoryCard>(foundOne, "", null);
        return ResponseEntity.status(200).body(responseBody);
    }
}
