package ca.ucareer.computerfactory.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    List<Computer> getComputers(){
        return computerRepository.findAll();
    }

    Computer receiveComputers(int id){
        return computerRepository.findById(id).orElse(null);
    }

    Computer createComputers(Computer computerbody){
        Computer savedComputer = new Computer();
        savedComputer.setLabel(computerbody.getLabel());
        savedComputer.setPrice(computerbody.getPrice());
        savedComputer.setType(computerbody.getType());
        return savedComputer;
    }

    Computer updateComputers(Computer computerbody, int id){
        Computer savedComputer = computerRepository.findById(id).orElse(null);
        if (savedComputer != null) {
            savedComputer.setPrice(computerbody.getPrice());
            savedComputer.setLabel(computerbody.getLabel());
            savedComputer.setType(computerbody.getType());
            return computerRepository.save(savedComputer);

        }else{
            return null;
        }
    }

    boolean deleteComputers(int id){
        Computer foundComputer = computerRepository.findById(id).orElse(null);
        if (foundComputer != null){
            return true;
        }else{
            return false;
        }
    }




}
