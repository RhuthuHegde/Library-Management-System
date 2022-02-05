package com.example.librarysystem.Models;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class BookOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO,generator = "order_generator")
    @SequenceGenerator(name="order_generator",allocationSize = 1,sequenceName = "orderSequence")

    private Long orderId;
    @Column
    private String isbnNo;
    @Column
    private String bookingDate;

    public BookOrder(String isbnNo, String bookingDate) {
        this.isbnNo = isbnNo;
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

    public String getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(String isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "orderId=" + orderId +
                ", isbnNo='" + isbnNo + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                '}';
    }
}
