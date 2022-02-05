package com.example.librarysystem.Controller;

import com.example.librarysystem.Models.User;
import com.example.librarysystem.Repository.UserRepository;
import com.example.librarysystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping({"/users"})
    public List<User> getbooks()
    {
        return userService.getAllusers();
    }
    @GetMapping("/countusers")
    public String count()
    {
        Long value= userService.countusers();
        return "The number of users subscribed to the library are: "+value;
    }
    @GetMapping("/users/{userName}")
    public User search(@PathVariable String userName)
    {
        return userService.getbyUsername(userName);
    }
    @PostMapping("/addusers")
    public String add(@RequestBody User user)
    {
        userService.saveAllusers(user);
        return "User saved with ID "+user.getUserId();
    }
    @PutMapping("/updateusers/{userId}")
    public String change(@PathVariable Long userId, @RequestBody User user)
    {
        userService.updateuser(userId,user);
        return "The user with following id is updated with new user values "+userId;
    }

    @DeleteMapping("/deleteuser/{userId}")
    public String delete(@PathVariable Long userId)
    {
        userService.deleteuser(userId);
        return "The user with following ID has been deleted: "+userId;
    }

}
