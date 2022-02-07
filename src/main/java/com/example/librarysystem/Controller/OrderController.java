package com.example.librarysystem.Controller;

import com.example.librarysystem.Models.BookOrder;
import com.example.librarysystem.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<BookOrder>> getorder()
    {
        List<BookOrder> listOrders=orderService.getAllorders();
        return new ResponseEntity<>(listOrders, HttpStatus.OK);
    }
    @PostMapping("/orders/add")
   public ResponseEntity<String> orderbook(@RequestBody BookOrder orderDetails)
   {
       orderService.saveorder(orderDetails);
       return new ResponseEntity<>("The order with "+orderDetails.getOrderId()+" has been added",HttpStatus.CREATED);
   }
   @DeleteMapping("/orders/delete/{orderId}")
   public ResponseEntity<String> cancelorder(@PathVariable Long orderId)
   {
       orderService.deleteorder(orderId);
       return new ResponseEntity<>("The order with id "+orderId+" has been deleted",HttpStatus.OK);
   }

}
