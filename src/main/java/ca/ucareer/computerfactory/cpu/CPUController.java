package ca.ucareer.computerfactory.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.ResponseBody;

@RestController
@RequestMapping("/v1")
public class CPUController {
    @Autowired
    CPUService cpuService;

    //List @PathVariables extract values from the URI path
    @GetMapping("/CPUs")
    public ResponseEntity<ResponseBody> getCpus(@RequestBody CPU cpubody){

        return ResponseEntity.ok(responseBody);
    }

    //Retrieve
    @GetMapping("CPUs/{id}")
    public ResponseEntity<ResponseBody> retrieveCpus(@PathVariable int id){
        CPU cpu1 = new CPU();
        cpu1.setId(id);
        ResponseBody responseBody = new ResponseBody("Retrieved Successfully", cpu1, null)
        return ResponseEntity.ok(responseBody);
    }

    //Create
    @PostMapping("/CPUs")
    public ResponseEntity<ResponseBody> createCpus(@RequestBody CPU cpubody){
        CPU savedCpu = new CPU();
        savedCpu.setCore(cpubody.getCore());
        savedCpu.setDescription(cpubody.getDescription());
        savedCpu.setLabel(cpubody.getLabel());
        savedCpu.setPrice(cpubody.getPrice());
        savedCpu.setStatus(cpubody.getStatus());
        ResponseBody responsebody = new ResponseBody("Test message", savedCpu, null);
        return ResponseEntity.ok(responsebody);
    }

    //Update
    @PostMapping("/CPUs/{id}")
    public ResponseEntity<ResponseBody> updateCpus(@PathVariable int id, @RequestBody CPU cpubody){
        CPU savedCpu = new CPU();
        savedCpu.setId(id);
        savedCpu.setCore(cpubody.getCore());
        savedCpu.setDescription(cpubody.getDescription());
        savedCpu.setLabel(cpubody.getLabel());
        savedCpu.setPrice(cpubody.getPrice());
        savedCpu.setStatus(cpubody.getStatus());
        ResponseBody responsebody = new ResponseBody("Test message", savedCpu, null);
        return ResponseEntity.ok(responsebody);
    }


    //Delete
    @DeleteMapping("CPUs/{id}")
    public ResponseEntity<ResponseBody> deleteCpus(@PathVariable int id){
        ResponseBody responsebody = new ResponseBody("CPU deleted", null, null);
        return ResponseEntity.ok(responsebody);
    }


}
