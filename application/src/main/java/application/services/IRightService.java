package application.services;

import db.models.Right;

public interface IRightService {
    //region CRUD
    Right getRight(Long id);
    Right addRight(Right right);
    Right updateRight(Right right);
    void deleteRight(Long id);
    //endregion
}
