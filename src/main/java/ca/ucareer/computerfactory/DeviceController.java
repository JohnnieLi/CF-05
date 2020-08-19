package ca.ucareer.computerfactory;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class DeviceController {
    //List all devices
    @GetMapping("/devices")
    public ResponseEntity<ResponseBody> getDevices(){
        Device device_1 =  new Device(1, "A", 10);
        Device device_2 =  new Device(2, "B", 20);
        ArrayList<Device> devices  = new ArrayList<>();
        devices.add(device_1);
        devices.add(device_2);


        ResponseBody responsebody = new ResponseBody<ArrayList<Device>>(devices, null,null);
        return ResponseEntity.ok(responsebody);
    }
    //get a device by id
    @GetMapping("/devices/{id}")
    public ResponseEntity<ResponseBody>getDeviceById(@PathVariable int id){
        Device device_1 =  new Device(1, "A", 10);
        Device device_2 =  new Device(2, "B", 20);
        ArrayList<Device> devices  = new ArrayList<>();
        devices.add(device_1);
        devices.add(device_2);
        Device deviceFound = DeviceService.findById(id, devices);
        String finalMessage = null;
        if (deviceFound !=null){

            finalMessage= "This is the information for device with id = "+ id;
        }
        else {
            finalMessage= "Device with id = "+ id + " does not exist";}

        ResponseBody responsebody = new ResponseBody<Device>(deviceFound, finalMessage,null);
        return ResponseEntity.ok(responsebody);

    }

    //Creat a new device
    @PostMapping("/devices")
    public ResponseEntity<ResponseBody> creatDevice(@RequestBody Device deviceBody){
        Device deviceCreated = new Device();
        deviceCreated.setId(0);
        deviceCreated.setName(deviceBody.getName());
        deviceCreated.setPrice(deviceBody.getPrice());


        String finalMessage = "New device has been created.";

        ResponseBody responsebody = new ResponseBody<Device>(deviceCreated, finalMessage,null);
        return ResponseEntity.ok(responsebody);

    }

    @PostMapping("/devices/{id}")
    public ResponseEntity updateDevice(@PathVariable("id") int id,@RequestBody Device deviceBody){
        Device device_1 =  new Device(1, "A", 10);
        Device device_2 =  new Device(2, "B", 20);
        ArrayList<Device> devices  = new ArrayList<>();
        devices.add(device_1);
        devices.add(device_2);
        Device deviceToUpdate = DeviceService.findById(id, devices);
        String finalMessage = null;
        if (deviceToUpdate !=null){
            deviceToUpdate.setName(deviceBody.getName());
            deviceToUpdate.setPrice(deviceBody.getPrice());
            finalMessage= "Device with id = " + id + " has been updated";
            ResponseBody responsebody = new ResponseBody<Device>(deviceToUpdate, finalMessage,null);
            return ResponseEntity.ok(responsebody);
        }
        else {
            finalMessage= "Device with id = "+ id + " does not exist";
            ResponseBody responsebody_error = new ResponseBody<Device>(null,"Unable to upate. User with id " + id + " not found.",null);
            return  ResponseEntity.ok(responsebody_error);
                    }

    }

    @DeleteMapping("/devices/{id}")
    public ResponseEntity<ResponseBody> deleteDevice(@PathVariable int id){
        Device device_1 =  new Device(1, "A", 10);
        Device device_2 =  new Device(2, "B", 20);
        ArrayList<Device> devices  = new ArrayList<>();
        devices.add(device_1);
        devices.add(device_2);
        Device deviceFound = DeviceService.findById(id, devices);

        String finalMessage = null;
        if (deviceFound !=null){
            DeviceService.deleteDeviceById(deviceFound.getId(), devices);
            finalMessage= "Device with id = "+ id + " has been deleted";
        }
        else {
            finalMessage= "Device with id = "+ id + " does not exist";}

        ResponseBody responsebody = new ResponseBody<Device>(deviceFound, finalMessage,null);
        return ResponseEntity.ok(responsebody);
    }


}



