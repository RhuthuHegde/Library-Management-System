package com.example.librarysystem.Services;

import com.example.librarysystem.Models.BookOrder;

import java.awt.print.Book;
import java.util.List;

public interface OrderService {

//    saving all the orders in table
    BookOrder saveorder(BookOrder order);
//    listing all orders from repository
    List<BookOrder> getAllorders();
    //delete the order for the list
    BookOrder deleteorder(Long id);
}
