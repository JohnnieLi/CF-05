package ca.ucareer.computerfactory.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUService {

    @Autowired
    CPURepository cpuRepository;

    //List all CPUs
    List<CPU> list() {
        return cpuRepository.findAll();
    }

    //Get one CPU
    CPU find(int id) {
        return cpuRepository.findById(id).orElse(null);
    }
    //Creat one CPU
    CPU create(CPU cpuBody) {
        CPU savedCPU = new CPU();
        savedCPU.setStatus(cpuBody.getStatus());
        savedCPU.setLabel(cpuBody.getLabel());
        savedCPU.setDescription(cpuBody.getDescription());
        savedCPU.setPrice(cpuBody.getPrice());
        savedCPU.setCore(cpuBody.getCore());
        savedCPU.setSpeed(cpuBody.getSpeed());
        return cpuRepository.save(savedCPU);
    }

    //Update one CPU
    CPU update(int id, CPU cpuBody) {
        CPU foundCPU = cpuRepository.findById(id).orElse(null);
        if (cpuBody.getStatus() != null){
            foundCPU.setStatus(cpuBody.getStatus());
        }
        if (cpuBody.getLabel() != null) {
            foundCPU.setLabel(cpuBody.getLabel());
        }
        if (cpuBody.getDescription() != null) {
            foundCPU.setDescription(cpuBody.getDescription());
        }
        if (cpuBody.getPrice() != null){
            foundCPU.setPrice(cpuBody.getPrice());
        }
        if (cpuBody.getCore() != null){
            foundCPU.setCore(cpuBody.getCore());
        }
        if (cpuBody.getSpeed() != null){
            foundCPU.setSpeed(cpuBody.getSpeed());
        }
        return cpuRepository.save(foundCPU);

    }

    //Delete one CPU
    void delete(int id) {
        cpuRepository.deleteById(id);
    }
}