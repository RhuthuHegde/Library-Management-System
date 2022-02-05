package com.example.librarysystem.Services.ServiceImpl;

import com.example.librarysystem.Exception.ResourceNotFoundException;
import com.example.librarysystem.Models.User;
import com.example.librarysystem.Repository.UserRepository;
import com.example.librarysystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveAllusers(User user) {
       return userRepository.save(user);
    }

    @Override
    public List<User> getAllusers() {
        return userRepository.findAll();
    }

    @Override
    public Long countusers() {
        return userRepository.count();
    }

    @Override
    public User getbyUsername(String name) {
        User userName= userRepository.findUserByUserName(name);
        if(userName==null)
        {
            throw new ResourceNotFoundException("User name not found", "User", "name", name);
        }
        return userName;
    }

    @Override
    public User updateuser(Long id,User user) {
        User updatedUser=userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User id not found","User","id",id));
        updatedUser.setUserName(user.getUserName());
        updatedUser.setUserLoc(user.getUserLoc());
        updatedUser.setDob(user.getDob());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    @Override
    public User deleteuser(Long id) {
        User deleteUser=userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Id is not found for deletion","User","id",id)
        );
       userRepository.delete(deleteUser);
       return deleteUser;
    }
}
