package application.controllers;

import application.services.IDriverService;
import db.models.Driver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {
    private final IDriverService driverService;
    public DriverController(IDriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Driver> getAll() {
        return driverService.getAll();
    }
    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Driver getDriver(@RequestParam(name = "id") Integer id){
        return driverService.getDriver(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Driver addDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Driver updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }
    @DeleteMapping()
    public void deleteDriver(@RequestParam(name = "id") Integer id){
        driverService.deleteDriver(id);
    }
    //endregion
}
