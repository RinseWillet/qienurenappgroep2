package app.qienuren.rest;

import app.qienuren.controller.UserService;
import app.qienuren.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserEndpoint {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User newTrainee(@RequestBody User user) {
        return userService.addUser(user);
    }

}


