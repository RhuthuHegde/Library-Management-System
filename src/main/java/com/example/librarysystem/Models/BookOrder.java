package com.example.librarysystem.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class BookOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO,generator = "order_generator")
    @SequenceGenerator(name="order_generator",initialValue = 1,allocationSize = 1,sequenceName = "orderSequence")
    private Long orderId;

    @Column
    private String bookName;

    @Column
    private String bookingDate;

    @ManyToOne
    @JoinColumn(name="fk_user_id", referencedColumnName = "user_id",nullable = false)
    private User userOrder;

    public BookOrder(String bookName, String bookingDate) {
        this.bookName = bookName;
        this.bookingDate = bookingDate;
    }

    public BookOrder() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String isbnNo) {
        this.bookName = isbnNo;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public User getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(User userOrder) {
        this.userOrder = userOrder;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "orderId=" + orderId +
                ", bookName='" + bookName + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                '}';
    }
}
