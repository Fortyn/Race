package application.services;

import application.repositories.MessageRepository;
import db.models.Message;

public interface IMessageService {
    //region CRUD
    Message getMessage(Long id);
    Message addMessage(Message message);
    Message updateMessage(Message message);
    void deleteMessage(Long id);
    //endregion
}
