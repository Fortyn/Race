package application.services.implementation;

import application.repositories.ChatRepository;
import application.services.IChatService;
import db.models.Chat;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ChatService implements IChatService {
    private final ChatRepository chatRepository;
    public ChatService(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }
    @Override
    public Chat getChat(Long id) {
        return chatRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public Chat addChat(Chat chat) {
        if(chat.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        return chatRepository.save(chat);
    }

    @Override
    public Chat updateChat(Chat chat) {
        if(!chatRepository.existsById(chat.getId())) throw new NoSuchElementException("No value present");
        return chatRepository.save(chat);
    }

    @Override
    public void deleteChat(Long id) {
        chatRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
