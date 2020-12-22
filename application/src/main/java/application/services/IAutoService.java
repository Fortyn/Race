package application.services;

import db.models.Auto;

public interface IAutoService {
    //region CRUD
    Auto getAuto(Integer id);
    Auto addAuto(Auto auto);
    Auto updateAuto(Auto auto);
    void deleteAuto(Integer id);
    //endregion
}
