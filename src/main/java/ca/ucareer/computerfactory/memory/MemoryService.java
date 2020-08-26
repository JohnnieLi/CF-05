package ca.ucareer.computerfactory.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MemoryService {
    @Autowired
    MemoryRepository memoryRepository;

    //Get a list of memory
    public List<Memory> list(){
        return memoryRepository.findAll();
    }

    //Get the memory with the ID
    public Memory retrieveMemory(int id){
        return memoryRepository.findById(id).orElse(null);
    }

    //Create a memory
    public Memory createMemory(Memory memoryBody){
        Memory savedMemory = new Memory();
        savedMemory.setLabel(memoryBody.getLabel());
        savedMemory.setPrice(memoryBody.getPrice());
        savedMemory.setType(memoryBody.getType());
        return savedMemory;
    }

    //Update the memory with the ID
    public Memory updateMemory(Memory memoryBody, int id){
        Memory foundMemory = memoryRepository.findById(id).orElse(null);
        if (foundMemory != null){
            Memory savedMemory = new Memory();
            savedMemory.setLabel(memoryBody.getLabel());
            savedMemory.setPrice(memoryBody.getPrice());
            savedMemory.setType(memoryBody.getType());
            return savedMemory;
        }else{
            return null;
        }
    }

    //Delete the memory with the ID
    public boolean deleteMemory( int id){
        Memory foundMemory = memoryRepository.findById(id).orElse(null);
        if (foundMemory != null){
            memoryRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
