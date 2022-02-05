package com.example.librarysystem.Repository;

import com.example.librarysystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
}
