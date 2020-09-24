package ca.ucareer.computerfactory.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    List<Computer> listComputers() {
        return computerRepository.findAll();
    }


    Computer getComputerById(Integer id) {
        return computerRepository.findById(id).orElse(null);
    }


    Computer createComputer(Computer savingOne) {
        return computerRepository.save(savingOne);
    }
}
