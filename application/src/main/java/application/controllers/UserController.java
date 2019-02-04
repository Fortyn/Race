package application.controllers;

import application.services.IUserService;
import db.models.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService userService;
    public UserController(IUserService userService){
        this.userService = userService;
    }

    //region CRUD
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@RequestParam(name = "id") Long id){
        return userService.getUser(id);
    }

    @PostMapping(path = "/reg",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping()
    public void deleteUser(@RequestParam(name = "id") Long id){
        userService.deleteUser(id);
    }
    //endregion
}
