package application.controllers;

import application.services.IChatService;
import db.models.Chat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final IChatService chatService;
    public ChatController(IChatService chatService){
        this.chatService = chatService;
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Chat getChat(@RequestParam(name = "id") Long id){
        return chatService.getChat(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Chat addChat(@RequestBody Chat chat){
        return chatService.addChat(chat);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Chat updateChat(@RequestBody Chat chat){
        return chatService.updateChat(chat);
    }
    @DeleteMapping()
    public void deleteChat(@RequestParam(name = "id") Long id){
        chatService.deleteChat(id);
    }
    //endregion
}
