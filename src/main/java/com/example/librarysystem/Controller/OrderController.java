package com.example.librarysystem.Controller;

import com.example.librarysystem.Models.BookOrder;
import com.example.librarysystem.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<BookOrder> getorder()
    {
        return orderService.getAllorders();
    }
    @PostMapping("/orders/add")
   public String orderbook(@RequestBody BookOrder orderDetails)
   {
       orderService.saveorder(orderDetails);
       return "Order details are saved";
   }
   @DeleteMapping("/orders/delete/{orderId}")
   public String cancelorder(@PathVariable Long orderId)
   {
       orderService.deleteorder(orderId);
       return "Order with id "+orderId+ " has been removed";
   }

}
