package com.example.librarysystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO,generator = "user_generator")
    @SequenceGenerator(name="user_generator",initialValue = 1,allocationSize = 1,sequenceName = "userSequence")
    private Long userId;
    @Column
    private String userName;
    @Column
    private String dob;
    @Column
    private String userLoc;

    @JsonIgnore
    @OneToMany(mappedBy = "user",targetEntity = Books.class,cascade = CascadeType.ALL)
    private List<Books> books;

    @JsonIgnore
    @OneToMany(mappedBy = "userOrder",targetEntity = BookOrder.class,cascade = CascadeType.ALL)
    private List<BookOrder> orders;

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

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public List<BookOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<BookOrder> orders) {
        this.orders = orders;
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
