package application.controllers;

import application.services.IMessageService;
import db.models.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final IMessageService messageService;
    public MessageController(IMessageService messageService){
        this.messageService = messageService;
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Message getMessage(@RequestParam(name = "id") Long id){
        return messageService.getMessage(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Message addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Message updateMessage(@RequestBody Message message){
        return messageService.updateMessage(message);
    }
    @DeleteMapping()
    public void deleteMessage(@RequestParam(name = "id") Long id){
        messageService.deleteMessage(id);
    }
    //endregion
}
