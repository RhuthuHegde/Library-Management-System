package com.example.librarysystem.Models;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO,generator = "user_generator")
    @SequenceGenerator(name="user_generator",allocationSize = 1,sequenceName = "userSequence")
    private Long userId;
    @Column
    private String userName;
    @Column
    private String dob;
    @Column
    private String userLoc;

    public User(String userName, String dob, String userLoc) {
        this.userName = userName;
        this.dob = dob;
        this.userLoc = userLoc;
    }

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUserLoc() {
        return userLoc;
    }

    public void setUserLoc(String userLoc) {
        this.userLoc = userLoc;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dob='" + dob + '\'' +
                ", userLoc='" + userLoc + '\'' +
                '}';
    }
}
