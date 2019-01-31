package application.services.implementation;

import application.repositories.RightRepository;
import application.services.IRightService;
import db.models.Right;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RightService implements IRightService {
    private final RightRepository rightRepository;
    public RightService(RightRepository rightRepository){
        this.rightRepository = rightRepository;
    }
    @Override
    public Right getRight(Long id) {
        return rightRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public Right addRight(Right right) {
        if(right.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return rightRepository.save(right);
    }

    @Override
    public Right updateRight(Right right) {
        if(!rightRepository.existsById(right.getId())) throw new NoSuchElementException("No value present");
        return rightRepository.save(right);
    }

    @Override
    public void deleteRight(Long id) {
        rightRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
