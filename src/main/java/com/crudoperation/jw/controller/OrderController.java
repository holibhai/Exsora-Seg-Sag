package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Order;
import com.crudoperation.jw.service.serviceImp.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Response>addOrder(@RequestBody Order order) {
         return ResponseEntity.ok(orderService.addOrder(order));
    }

    @GetMapping("/get")
    public ResponseEntity<Response>getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response>updateOrder(@RequestBody Order order,@PathVariable int id) {
        return ResponseEntity.ok(orderService.updateOrder(order,id));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response>getOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
