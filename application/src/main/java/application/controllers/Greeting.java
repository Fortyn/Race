package application.controllers;

import application.services.IChatService;
import application.services.implementation.ChatService;
import db.models.Chat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting { //for testing
    private final IChatService chatService;
    public Greeting(ChatService chatService){
        this.chatService = chatService;
    }
    @GetMapping("/")
    public String greeting(){
        return "Hello, "+chatService.getChat(0L).getName();
    }
}
