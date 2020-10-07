package ca.ucareer.computerfactory.Head;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadService {

    @Autowired
    HeadRepository headRepository;

    //List all heads
    List<Head> list() {
        return headRepository.findAll();
    }

    //Get one Head
    Head findById(int id) {
        return headRepository.findById(id).orElse(null);
    }

    //Creat one Head
    Head create(Head headBody) {
        Head savedHead = new Head();
        savedHead.setStatus(headBody.getStatus());
        savedHead.setTitle(headBody.getTitle());
        savedHead.setDescription(headBody.getDescription());
        savedHead.setUrl(headBody.getUrl());
        return headRepository.save(savedHead);
    }

    //Update one Head
    Head update(int id, Head headBody) {
        Head foundHead = headRepository.findById(id).orElse(null);
        if (headBody.getStatus() != null){
            foundHead.setStatus(headBody.getStatus());
        }
        if (headBody.getStatus() != null) {
            foundHead.setStatus(headBody.getStatus());
        }
        if (headBody.getDescription() != null) {
            foundHead.setDescription(headBody.getDescription());
        }
        if (headBody.getTitle() != null){
            foundHead.setTitle(headBody.getTitle());
        }
        if (headBody.getUrl() != null){
            foundHead.setUrl(headBody.getUrl());
        }
        return headRepository.save(foundHead);
    }

    //Delete one Head
    void delete(int id) {
        headRepository.deleteById(id);
    }
}