package ucareer.device;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucareer.ResponseBody;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/v1")

public class DeviceController {
    //list
    @GetMapping("/devices")
    public ResponseEntity<ResponseBody> getdevices(@RequestParam(required = false) Optional<Integer> page) {
        System.out.println("1");
        Device device1= new Device();
        device1.setId(001);
        device1.setName("apple");
        device1.setPrice(1000);

        Device device2= new Device();
        device2.setId(002);
        device2.setName("hammer");
        device2.setPrice(600);

        Device device3= new Device();
        device3.setId(003);
        device3.setName("mi");
        device3.setPrice(800);

        ArrayList<Device> devices = new ArrayList<>();
        devices.add(device1);
        devices.add(device2);
        devices.add(device3);

        ResponseBody responseBody = new ResponseBody<List<Device>>(devices, "text message", null);
        return ResponseEntity.ok(responseBody);

    }

    //retrieve
    @GetMapping("/devices/{id}")
    public ResponseEntity<ResponseBody> getdevices(@PathVariable int id) {
        Device device1=new Device();
        device1.setPrice(1000);
        device1.setName("apple");
        device1.setId(id);
        ResponseBody responseBody = new ResponseBody(device1, "id retrieval", null);
        return ResponseEntity.ok(responseBody);
    }

    //create
    @PostMapping("devices")
    public ResponseEntity<ResponseBody> createdevices(@RequestBody Device devicebody){
        Device saveDevice= new Device();
        saveDevice.setName(devicebody.getName());
        saveDevice.setPrice(devicebody.getPrice());
        saveDevice.setId(100);
        ResponseBody responseBody = new ResponseBody(saveDevice, "create new device", null);
        return ResponseEntity.ok(responseBody);
    }

    //update
    @PostMapping("devices/{id}")
    public ResponseEntity<ResponseBody> updatedevices(@PathVariable int id, @RequestBody Device devicebody){
        Device saveDevice= new Device();
        saveDevice.setId(id);
        saveDevice.setPrice(devicebody.getPrice());
        saveDevice.setName(devicebody.getName());
        ResponseBody responseBody = new ResponseBody(saveDevice, "update the device with id", null);
        return ResponseEntity.ok(responseBody);
    }

    //delete
    @DeleteMapping("devices/{id}")
    public boolean deletedevices(@PathVariable int id){
        ResponseBody responseBody = new ResponseBody(null, "Sucessfully deleted", null);
        //return ResponseEntity.ok(responseBody);
        return true;
    }
}
