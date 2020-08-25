package ca.ucareer.computerfactory.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ca.ucareer.computerfactory.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class CPUController {
    @Autowired
    CPUService cpuService;

    //List @PathVariables extract values from the URI path
    @GetMapping("/CPUs")
    public ResponseEntity<ResponseBody> list(){
        List<CPU> cpuBody = cpuService.getCpus();
        ResponseBody responseBody = new ResponseBody("Retrieved Successfully", cpuBody, null);
        return ResponseEntity.ok(responseBody);
    }

    //Retrieve
    @GetMapping("CPUs/{id}")
    public ResponseEntity<ResponseBody> retrieveCpus(@PathVariable int id){
        CPU cpu1 = cpuService.retrieveCpu(id);
        ResponseBody responseBody = new ResponseBody("Retrieved Successfully", cpu1, null);
        return ResponseEntity.ok(responseBody);
    }

    //Create
    @PostMapping("/CPUs")
    public ResponseEntity<ResponseBody> createCpus(@RequestBody CPU cpubody){
        CPU savedCpu = cpuService.createCpu(cpubody);
        ResponseBody responsebody = new ResponseBody("Test message", savedCpu, null);
        return ResponseEntity.ok(responsebody);
    }

    //Update
    @PostMapping("/CPUs/{id}")
    public ResponseEntity<ResponseBody> updateCpus(@PathVariable int id, @RequestBody CPU cpubody){
        CPU savedCpu = cpuService.updateCpu(cpubody, id);
        ResponseBody responsebody = new ResponseBody("Test message", savedCpu, null);
        return ResponseEntity.ok(responsebody);
    }


    //Delete
    @DeleteMapping("CPUs/{id}")
    public ResponseEntity<ResponseBody> deleteCpus(@PathVariable int id){
        boolean foundCpu = cpuService.deleteCpu(id);
        if (foundCpu == true) {
            ResponseBody responsebody = new ResponseBody("CPU deleted", null, null);
            return ResponseEntity.ok(responsebody);
        }else{
            ResponseBody responsebody = new ResponseBody("No such CPU", null, null);
            return ResponseEntity.ok(responsebody);
        }
    }


}
