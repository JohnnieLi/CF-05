package ca.ucareer.computerfactory.controller;

import ca.ucareer.computerfactory.model.cpu.CPU;
import ca.ucareer.computerfactory.model.cpu.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.response.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CPUController {

    @Autowired
    CPUService cpuService;

    @PostMapping("/cpus")
    public ResponseEntity<ResponseBody> createCPU(@RequestBody CPU cpuBaby){
        CPU savedCPU = cpuService.createCPU(cpuBaby);
        ResponseBody<CPU> requestBody = new ResponseBody(savedCPU, "", null);
        return ResponseEntity.ok(requestBody);
    }

    @GetMapping("/cpus")
    public ResponseEntity<ResponseBody> listCPUs(){
        List<CPU> cpusList = cpuService.listCPU();
        ResponseBody<List> responseBody = new ResponseBody(cpusList, "here is all cpus", null);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/cpus/{id}")
    public ResponseEntity<ResponseBody> retrieveCPUs(@PathVariable("id") Integer id){
        CPU findCPU = cpuService.readCPU(id);
        ResponseBody responseBody = new ResponseBody(findCPU, "find it", null);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/cpus/{id}")
    public ResponseEntity<ResponseBody> updateCPU(@PathVariable("id") Integer id,
                                                  @RequestBody CPU cpuBaby){
        cpuBaby.setId(id);
        boolean ifUpdated = cpuService.updateCPU(cpuBaby);
        if(ifUpdated == true){
            ResponseBody responseBody = new ResponseBody(true, "updated successfully", null);
            return ResponseEntity.ok(responseBody);
        }
        else{
            ResponseBody responseBody = new ResponseBody(false, "update fail", null);
            return ResponseEntity.ok(responseBody);
        }
    }

    @DeleteMapping("/cpus/{id}")
    public ResponseEntity<ResponseBody> deleteCPU(@PathVariable("id") Integer id){
        CPU deletedCPU = cpuService.deleteCPU(id);
        if(deletedCPU != null){
            ResponseBody responseBody = new ResponseBody(deletedCPU, "delete it", null);
            return ResponseEntity.ok(responseBody);
        }
        else{
            ResponseBody responseBody = new ResponseBody(false, "can't find it!", null);
            return ResponseEntity.ok(responseBody);
        }
    }

}
