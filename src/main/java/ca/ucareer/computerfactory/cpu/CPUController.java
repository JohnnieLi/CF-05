package ca.ucareer.computerfactory.cpu;

import ca.ucareer.computerfactory.ResponseBody;
import ca.ucareer.computerfactory.device.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class CPUController {

    @Autowired
    CPUService cpuService;

    @GetMapping("/cpus")
    public ResponseEntity<ca.ucareer.computerfactory.ResponseBody> getCPUList() {
        List<CPU> CPUList = cpuService.list();
        String finalMessage = "CPU list has been obtained";
        ca.ucareer.computerfactory.ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<>(CPUList, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/cpus/{id}")
    public ResponseEntity<ca.ucareer.computerfactory.ResponseBody> getCPUById(@PathVariable int id) {
        CPU CPUFound = cpuService.retrieve(id);
        String finalMessage = "";
        if (CPUFound != null){
            finalMessage = "CPU with id = " + id + " has been found.";
        }
        else {
            finalMessage = "CPU with id = " + id + " does not exist.";
        }
        ca.ucareer.computerfactory.ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<>(CPUFound, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/cpus")
    public ResponseEntity<ca.ucareer.computerfactory.ResponseBody>creatCPU(@RequestBody CPU CPUBody){
        CPU CPUCreated =cpuService.create(CPUBody);
        String finalMessage = "New CPU has been created.";
        ca.ucareer.computerfactory.ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<>(CPUCreated, finalMessage,null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/cpus/{id}")
    public ResponseEntity<ca.ucareer.computerfactory.ResponseBody> updateById(@PathVariable int id, @RequestBody CPU CPUBody){
        CPU CPUToUpdate = cpuService.retrieve(id);
        String finalMessage = "";
        if (CPUToUpdate != null){
            CPUToUpdate = cpuService.update(id, CPUBody);
            finalMessage = "CPU with id = " + id + " has been updated.";

        }
        else {
            finalMessage = "CPU with id = " + id + " does not exist.";
        }
        ca.ucareer.computerfactory.ResponseBody responseBody = new ca.ucareer.computerfactory.ResponseBody<>(CPUToUpdate, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("cpus/{id}")
    public ResponseEntity<ResponseBody> deleteById(@PathVariable int id){
        CPU CPUToDelete = cpuService.retrieve(id);
        String finalMessage = "";
        if (CPUToDelete != null){
            cpuService.delete(id);
            finalMessage = "CPU with id = " + id + " has been deleted.";

        }
        else {
            finalMessage = "CPU with id = " + id + " does not exist.";
        }
        ResponseBody responseBody = new ResponseBody<>(CPUToDelete, finalMessage, null);
        return ResponseEntity.ok(responseBody);
    }

}


