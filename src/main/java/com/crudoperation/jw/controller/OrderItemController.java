package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.OrderItem;
import com.crudoperation.jw.service.serviceImp.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add")
    public ResponseEntity<Response>addOrderItem(@RequestBody OrderItem orderItem) {
        return ResponseEntity.ok(orderItemService.addOrderItem(orderItem));
    }
}
