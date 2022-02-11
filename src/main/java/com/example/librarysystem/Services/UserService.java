package com.example.librarysystem.Services;

import com.example.librarysystem.Models.User;

import java.util.List;

public interface UserService {
    //get user by user id
    User findById(Long id);
//    saves the user in the tables of DB
    User saveAllusers(User user);
//    get the books from the repository
    List<User> getAllusers();
//    count the number of users registered
    Long countusers();
    //find user by username
    User getbyUsername(String name);
//    update the existing user details
    User updateuser(Long id,User user);
    //delete the user by id
    User deleteuser(Long id);
}


