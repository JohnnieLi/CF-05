package ca.ucareer.computerfactory.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUService {


    @Autowired
    CPURepository cpuRepository;

    CPU create(CPU cpuBody) {
        CPU savingCPU = new CPU();
        savingCPU.setLabel(cpuBody.getLabel());
        savingCPU.setDescription(cpuBody.getDescription());
        return cpuRepository.save(savingCPU);
    }

    CPU findByLabel(String label){
        return cpuRepository.findCPUByLabel(label);
    }

    List<CPU> list() {
        return cpuRepository.findAll();
    }

    CPU update(int id, CPU cpuBody) {
        CPU foundOne = cpuRepository.findById(id).orElse(null);
        if (foundOne != null) {
            if (cpuBody.getLabel() != null) {
                foundOne.setLabel(cpuBody.getLabel());
            }
            if (cpuBody.getDescription() != null) {
                foundOne.setDescription(cpuBody.getDescription());
            }
            return cpuRepository.save(foundOne);
        } else {
            return null;
        }
    }


    CPU retrieve(int id) {
        return cpuRepository.findById(id).orElse(null);
    }
}
