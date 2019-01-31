package application.services;

import db.models.User;

public interface IUserService {
    //region CRUD
    User getUser(Long id);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    //endregion
}
