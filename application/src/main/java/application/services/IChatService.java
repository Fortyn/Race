package application.services;

import db.models.Chat;

public interface IChatService {
    //region CRUD
    Chat getChat(Long id);
    Chat addChat(Chat chat);
    Chat updateChat(Chat chat);
    void deleteChat(Long id);
    //endregion
}
