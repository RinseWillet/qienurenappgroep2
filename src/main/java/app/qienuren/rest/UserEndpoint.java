package app.qienuren.rest;

import app.qienuren.controller.UserService;
import app.qienuren.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserEndpoint {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User newTrainee(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/test")
    public String test(){return "het werkt";}

}


