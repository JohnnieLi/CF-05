package ca.ucareer.computerfactory;



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

        for (Iterator<Device> iterator = devices.iterator(); iterator.hasNext(); ) {
            Device device = iterator.next();
            if (device.getId() == id) {
                iterator.remove();
            }
        }
    }

}
