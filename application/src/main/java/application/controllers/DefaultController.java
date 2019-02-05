package application.controllers;

import application.services.SecurityService;
import db.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {
    @Autowired
    private SecurityService service;
    @GetMapping("/signin")
    public String hello(){
        return "hello";
    }
    @PostMapping("/signin")
    public String login(@RequestParam("login") String login, //
                        @RequestParam("password") String password) {
        return service.signin(login, password);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return service.signup(user);
    }
}
