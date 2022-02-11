package com.example.librarysystem.Controller;

import com.example.librarysystem.Models.User;
import com.example.librarysystem.Repository.UserRepository;
import com.example.librarysystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping({"/users"})
    public ResponseEntity<List<User>> getbooks()
    {
        List<User> listUser=userService.getAllusers();
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }
    @GetMapping("/countusers")
    public ResponseEntity<String> count()
    {
        Long value= userService.countusers();
        return new ResponseEntity<>("The number of users subscribed to the library are "+value,HttpStatus.OK);
    }
    @GetMapping("/users/{userName}")
    public ResponseEntity<String> search(@PathVariable String userName)
    {
        User searchUser=userService.getbyUsername(userName);
        return new ResponseEntity<>("The user is"+searchUser,HttpStatus.OK);
    }
    @PostMapping("/addusers")
    public ResponseEntity<String> add(@RequestBody User user)
    {
        userService.saveAllusers(user);
        return new ResponseEntity<>("User saved with ID "+user.getUserId()+user,HttpStatus.CREATED);
    }
    @PutMapping("/updateusers/{userId}")
    public ResponseEntity<String> change(@PathVariable Long userId, @RequestBody User user)
    {
        userService.updateuser(userId,user);
        return new ResponseEntity<>("The user with following id is updated with new user values "+userId,HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity<String> delete(@PathVariable Long userId)
    {
        userService.deleteuser(userId);
        return new ResponseEntity<>("The user with following ID has been deleted: "+userId,HttpStatus.OK);
    }

}
