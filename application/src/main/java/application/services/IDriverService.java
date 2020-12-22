package application.services;

import db.models.Driver;

public interface IDriverService {
    //region CRUD
    Driver getDriver(Integer id);
    Driver addDriver(Driver driver);
    Driver updateDriver(Driver driver);
    void deleteDriver(Integer id);
    //endregion
}
