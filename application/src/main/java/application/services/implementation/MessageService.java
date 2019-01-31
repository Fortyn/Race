package application.services.implementation;

import application.repositories.MessageRepository;
import application.services.IMessageService;
import db.models.Message;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MessageService implements IMessageService {
    private final MessageRepository messageRepository;
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    @Override
    public Message getMessage(Long id) {
        return messageRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public Message addMessage(Message message) {
        if(message.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        if(!messageRepository.existsById(message.getId())) throw new NoSuchElementException("No value present");
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
