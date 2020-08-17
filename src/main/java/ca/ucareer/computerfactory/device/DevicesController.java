package ca.ucareer.computerfactory.device;

import ca.ucareer.computerfactory.response.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1")
public class DevicesController {

    // list
    @GetMapping("/devices")
    public ResponseEntity<ResponseBody> getDevices(){

        Devices d1 = new Devices(115, "iphone", 113.3);
        Devices d2 = new Devices(116, "samsung", 116.6);

        ArrayList<Devices> devicesList = new ArrayList<Devices>();
        devicesList.add(d1);
        devicesList.add(d2);

        ResponseBody<ArrayList<Devices>> rb = new ResponseBody<ArrayList<Devices>>(devicesList, "ok", null);

        return ResponseEntity.ok(rb);
    }

    // retrieve
    //@GetMapping("/devices/{id}/{mul_var}")
    @GetMapping("/devices/{id}")
    public ResponseEntity<ResponseBody> retrieveDevice(
            @PathVariable("id") int id){
        Devices d = new Devices(id, "One plus", 117.1);
        ResponseBody<Devices> rb = new ResponseBody<Devices>(d, "retrieve", null);
        return ResponseEntity.ok(rb);
    }

    // create
    @PostMapping("/devices")
    public ResponseEntity<ResponseBody> createDevice(@RequestBody Devices d){
        Devices dnew = new Devices(119, d.getName(), d.getPrice());
        ResponseBody<Devices> rb = new ResponseBody<Devices>(dnew, "create", null);
        return ResponseEntity.ok(rb);
    }

    //update
    @PostMapping("/devices/{id}")
    public ResponseEntity<ResponseBody> updateDevice(@PathVariable("id") int id,
                                                     @RequestBody Devices d){
        Devices dupdate = new Devices(id, d.getName(), d.getPrice());
        ResponseBody<Devices> rb = new ResponseBody<Devices>(dupdate, "update", null);
        return ResponseEntity.ok(rb);
    }

    //delete
    @DeleteMapping("/devices/{id}")
    public boolean deleteDevice(@PathVariable("id") int id){
        return true;
    }
}
