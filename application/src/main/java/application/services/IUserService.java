package application.services;

import db.models.User;

public interface IUserService {
    //region RUD
    User getUser(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    //endregion
}
