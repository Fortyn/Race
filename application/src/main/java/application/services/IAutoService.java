package application.services;

import db.models.Auto;

import java.util.List;

public interface IAutoService {

    List<Auto> getAll();

    //region CRUD
    Auto getAuto(Integer id);
    Auto addAuto(Auto auto);
    Auto updateAuto(Auto auto);
    void deleteAuto(Integer id);
    //endregion
}
