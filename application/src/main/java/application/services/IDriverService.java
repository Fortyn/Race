package application.services;

import db.models.Driver;

import java.util.List;

public interface IDriverService {

    List<Driver> getAll();
    //region CRUD
    Driver getDriver(Integer id);
    Driver addDriver(Driver driver);
    Driver updateDriver(Driver driver);
    void deleteDriver(Integer id);
    //endregion
}
