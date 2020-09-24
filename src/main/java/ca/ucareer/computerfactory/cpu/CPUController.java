package ca.ucareer.computerfactory.cpu;

import ca.ucareer.computerfactory.ResponseBody;
import ca.ucareer.computerfactory.computer.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CPUController {


    @Autowired
    CPUService cpuService;

    @PostMapping("/cpus")
    public ResponseEntity<ResponseBody> create(@RequestBody CPU cpuBody) {
        CPU savedCpu = cpuService.create(cpuBody);
        ResponseBody responseBody = new ResponseBody(savedCpu, "", null);
        return ResponseEntity.ok(responseBody);
    }


    @PutMapping("/cpus/{id}")
    public ResponseEntity<ResponseBody> update(@PathVariable int id, @RequestBody CPU cpuBody) {
        CPU updatedCpu = cpuService.update(id, cpuBody);

        if (updatedCpu != null) {
            ResponseBody responseBody = new ResponseBody(updatedCpu, "update ok", null);
            return ResponseEntity.ok(responseBody);
        } else {
            ResponseBody responseBody = new ResponseBody(null, "not exist", null);
            return ResponseEntity.ok(responseBody);
        }

    }


    @GetMapping("/cpus/{id}")
    public ResponseEntity<ResponseBody> retrieve(@PathVariable int id) {
        CPU foundOne = cpuService.retrieve(id);
        Computer computer = foundOne.getComputer();
        ResponseBody responseBody = new ResponseBody(foundOne, "", null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/cpus")
    public ResponseEntity<ResponseBody> list() {
        List<CPU> cpus = cpuService.list();
        ResponseBody responseBody = new ResponseBody(cpus, "", null);
        return ResponseEntity.ok(responseBody);
    }
}
