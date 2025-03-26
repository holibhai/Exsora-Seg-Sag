package com.crudoperation.jw.service;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.exception.OurException;
import com.crudoperation.jw.repo.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    private CartItemRepository cartItemRepository;

    public Response createCartItem() {
        Response response = new Response();
        try{

        }catch (OurException e){

        }
        return response;
    }
}
