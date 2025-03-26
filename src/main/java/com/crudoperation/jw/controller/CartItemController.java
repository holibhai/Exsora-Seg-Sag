package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.CartItem;
import com.crudoperation.jw.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    public ResponseEntity<Response> createCartItem( @RequestBody CartItem cartItem) {
        return ResponseEntity.ok(cartItemService.createCartItem());
    }
}
