package application.controllers;


import application.repositories.ChatRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    private ChatRepository repository;
    public Greeting(ChatRepository repository){
        this.repository = repository;
    }
    @GetMapping("/")
    public String greeting(){
        return "Hello, "+repository.findById(0L).orElseThrow().getName();
    }
}
