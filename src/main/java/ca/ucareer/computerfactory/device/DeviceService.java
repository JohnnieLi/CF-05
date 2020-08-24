package ca.ucareer.computerfactory.device;



import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DeviceService {
    public static Device findById(int id, ArrayList<Device> devices) {
        for(Device device : devices){
            if(device.getId() == id){
                return device;
            }
        }
        return null;
    }

    public static void deleteDeviceById(int id, ArrayList<Device> devices) {

        devices.removeIf(device -> device.getId() == id);
    }

}
