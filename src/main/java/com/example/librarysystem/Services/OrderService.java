package com.example.librarysystem.Services;

import com.example.librarysystem.Models.BookOrder;
import com.example.librarysystem.Repository.OrderRepository;

import java.util.List;

public interface OrderService {

//    saving all the orders in table
    BookOrder saveorder(BookOrder order);
//    listing all orders from repository
    List<BookOrder> getAllorders();
    //delete the order for the list
    OrderRepository deleteorder(Long id);
}
