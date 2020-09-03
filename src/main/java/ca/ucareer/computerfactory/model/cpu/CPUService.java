package ca.ucareer.computerfactory.model.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class CPUService {

    @Autowired
    CPURepository cpuRepository;

    public CPU createCPU(CPU CPUbaby){
        CPU savingCPU = new CPU();
        savingCPU.setCore(CPUbaby.getCore());
        savingCPU.setDescription(CPUbaby.getDescription());
        savingCPU.setLabel(CPUbaby.getLabel());
        savingCPU.setPrice(CPUbaby.getPrice());
        savingCPU.setStatus(CPUbaby.getStatus());
        savingCPU.setSpeed(CPUbaby.getSpeed());

        return cpuRepository.save(savingCPU);
    }

    public CPU readCPU(Integer findId){
        return cpuRepository.findCPUById(findId);
    }

    public List<CPU> listCPU(){
        return cpuRepository.findAll();
    }

    public boolean updateCPU(CPU cpuBaby){
        List<Integer> idList = cpuRepository.listAllId();
        if(idList.contains(cpuBaby.getId())){
            CPU updatingCPU = cpuRepository.findCPUById(cpuBaby.getId());
            if(cpuBaby.getCore() != 0) {
                updatingCPU.setCore(cpuBaby.getCore());
            }
            if(cpuBaby.getDescription() != null){
                updatingCPU.setDescription(cpuBaby.getDescription());
            }
            if(cpuBaby.getLabel() != null){
                updatingCPU.setLabel(cpuBaby.getLabel());
            }
            if(cpuBaby.getPrice() != 0){
                updatingCPU.setPrice(cpuBaby.getPrice());
            }
            if(cpuBaby.getSpeed() != null){
                updatingCPU.setSpeed(cpuBaby.getSpeed());
            }
            if(cpuBaby.getStatus() != null){
                updatingCPU.setStatus(cpuBaby.getStatus());
            }
            cpuRepository.save(updatingCPU);
            return true;
        }
        else return false;
    }

    public CPU deleteCPU(Integer id){
        CPU findCPU = cpuRepository.findById(id).orElse(null);
        if(findCPU != null){
            CPU deletedCPU = new CPU(id, findCPU.getStatus(), findCPU.getLabel(),
                    findCPU.getDescription(), findCPU.getPrice(), findCPU.getCore(),
                    findCPU.getSpeed());
            cpuRepository.deleteById(id);
            return deletedCPU;
        }
        else return null;
    }


}
