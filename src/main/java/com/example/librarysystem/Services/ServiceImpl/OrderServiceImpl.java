package com.example.librarysystem.Services.ServiceImpl;

import com.example.librarysystem.Exception.ResourceNotFoundException;
import com.example.librarysystem.Models.BookOrder;
import com.example.librarysystem.Repository.OrderRepository;
import com.example.librarysystem.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BookOrder saveorder(BookOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public List<BookOrder> getAllorders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderRepository deleteorder(Long id) {
        BookOrder order = orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Order id not found with id "+id));
        orderRepository.delete(order);
        return orderRepository;
    }
}
