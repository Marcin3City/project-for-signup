package pl.test.projectforsignup.controllers;


import org.springframework.web.bind.annotation.*;
import pl.test.projectforsignup.models.UserClass;
import pl.test.projectforsignup.services.UserService;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public List<UserClass> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public UserClass addUser(@RequestBody UserClass user){
        return userService.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("{id}") long id){
        userService.deleteUser(id);
    }

}
