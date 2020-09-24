package ca.ucareer.computerfactory.memory_card;

import ca.ucareer.computerfactory.computer.Computer;
import ca.ucareer.computerfactory.computer.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryCardService {


    @Autowired
    MemoryCardRepository repository;


    List<MemoryCard> listMemoryCards() {
        return repository.findAll();
    }


    MemoryCard getMemoryCardById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    MemoryCard createMemoryCard(MemoryCard savingOne) {
        return repository.save(savingOne);
    }

}
