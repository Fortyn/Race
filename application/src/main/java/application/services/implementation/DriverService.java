package application.services.implementation;

import application.repositories.DriverRepository;
import application.services.IDriverService;
import db.models.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DriverService implements IDriverService {
    private final DriverRepository driverRepository;
    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAll() {
        return StreamSupport.stream(driverRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Driver getDriver(Integer id) {
        return driverRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public Driver addDriver(Driver driver) {
        if(driver.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        if(!driverRepository.existsById(driver.getId())) throw new NoSuchElementException("No value present");
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Integer id) {
        driverRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
