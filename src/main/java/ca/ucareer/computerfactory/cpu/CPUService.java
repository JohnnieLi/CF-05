package ca.ucareer.computerfactory.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CPUService {
    @Autowired
    CPURepository cpuRepository;

    //Retrieve List of CPUs
    List<CPU> getCpus(){
        return cpuRepository.findAll();
    }

    //Retrieve a CPU with ID
    CPU retrieveCpu(int id){
        return cpuRepository.findById(id).orElse(null);
    }

    //Create a CPU
    CPU createCpu(CPU cpubody){
        CPU savedCpu = new CPU();
        savedCpu.setCore(cpubody.getCore());
        savedCpu.setDescription(cpubody.getDescription());
        savedCpu.setLabel(cpubody.getLabel());
        savedCpu.setPrice(cpubody.getPrice());
        savedCpu.setStatus(cpubody.getStatus());
        return cpuRepository.save(savedCpu);
    }

    //Update a CPU with ID
    CPU updateCpu(CPU cpubody, int id){
        CPU savedCpu = cpuRepository.findById(id).orElse(null);
        if (savedCpu != null){
            savedCpu.setCore(cpubody.getCore());
            savedCpu.setDescription(cpubody.getDescription());
            savedCpu.setLabel(cpubody.getLabel());
            savedCpu.setPrice(cpubody.getPrice());
            savedCpu.setStatus(cpubody.getStatus());
            return cpuRepository.save(savedCpu);
        }else{
            return null;
        }
    }

    //Delete the CPU with ID
    boolean deleteCpu(int id){
        CPU foundCpu = cpuRepository.findById(id).orElse(null);
        if (foundCpu != null){
            cpuRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
