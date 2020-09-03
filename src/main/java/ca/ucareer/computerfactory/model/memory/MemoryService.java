package ca.ucareer.computerfactory.model.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryService {

    @Autowired
    MemoryRepository memoryRepository;

    public MemoryCard createMemory(MemoryCard memoryBaby){
        MemoryCard memoryCard = new MemoryCard();
        if(memoryBaby.getLabel() != null){
            memoryCard.setLabel(memoryBaby.getLabel());
        }
        if(memoryBaby.getPrice() != 0){
            memoryCard.setPrice(memoryBaby.getPrice());
        }
        return memoryRepository.save(memoryCard);
    }

    public List<MemoryCard> listMemory(){
        return memoryRepository.findAll();
    }

    public MemoryCard retrieveMemory(Integer id){
        return memoryRepository.findById(id).orElse(null);
    }

    public MemoryCard updateMemory(MemoryCard memoryBaby){
        MemoryCard updatingMemory = memoryRepository.findById(memoryBaby.getId()).orElse(null);
        if(updatingMemory != null){
            if(memoryBaby.getLabel() != null){
                updatingMemory.setLabel(memoryBaby.getLabel());
            }
            if(memoryBaby.getPrice() != 0){
                updatingMemory.setPrice(memoryBaby.getPrice());
            }
            return memoryRepository.save(updatingMemory);
        }
        else return null;
    }

    public MemoryCard deleteMemory(Integer id){
        MemoryCard deletingMemory = memoryRepository.findById(id).orElse(null);
        if(deletingMemory != null){
            MemoryCard deletedMemory = new MemoryCard(deletingMemory.getId(),
                    deletingMemory.getLabel(), deletingMemory.getPrice(),
                    deletingMemory.getCreated_at(), deletingMemory.getModified_at(),
                    deletingMemory.getCreated_by());
            memoryRepository.deleteById(id);
            return deletedMemory;
        }
        else return null;

    }

}
