package application.services.implementation;

import application.repositories.AutoRepository;
import application.services.IAutoService;
import db.models.Auto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AutoService implements IAutoService {
    private final AutoRepository autoRepository;
    public AutoService(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    @Override
    public List<Auto> getAll() {
        return StreamSupport.stream(autoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Auto getAuto(Integer id) {
        return autoRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public Auto addAuto(Auto auto) {
        if(auto.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return autoRepository.save(auto);
    }

    @Override
    public Auto updateAuto(Auto auto) {
        if(!autoRepository.existsById(auto.getId())) throw new NoSuchElementException("No value present");
        return autoRepository.save(auto);
    }

    @Override
    public void deleteAuto(Integer id) {
        autoRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
