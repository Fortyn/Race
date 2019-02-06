package application.controllers;

import application.security.Authenticator;
import application.services.ISecurityService;
import db.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {

    private ISecurityService securityService;

    public SecurityController(ISecurityService securityService){
        this.securityService = securityService;
    }
    @PostMapping("/signin")
    public String login(@RequestBody Authenticator authenticator) {
        return securityService.signin(authenticator);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return securityService.signup(user);
    }
}
