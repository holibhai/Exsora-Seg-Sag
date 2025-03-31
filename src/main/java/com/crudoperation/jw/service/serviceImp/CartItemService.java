package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.CartItem;
import com.crudoperation.jw.model.User;
import com.crudoperation.jw.repo.CartItemRepository;
import com.crudoperation.jw.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    public CartItemRepository cartItemRepository;

    @Autowired
    public UserRepository userRepository;


    public Response createCartItem(int productId, int quantity,int userId) {
        Response response = new Response();
        try{
//            Optional <User> user = userRepository.findById(userId);
            List<CartItem> cartItem = cartItemRepository.findByUserId(userId);

                for (CartItem cartItem1 : cartItem) {
                      if(cartItem1.getProductId() == productId){
                          cartItem1.setQuantity(cartItem1.getQuantity()+quantity);
                          cartItemRepository.save(cartItem1);
                          response.setMessage("Successfully updated cart item");
                          response.setStatusCode(200);
                      }

                }

                CartItem cartItem2 = new CartItem();
                cartItem2.setProductId(productId);
                cartItem2.setQuantity(quantity);
                cartItem2.setProductId(productId);
                cartItemRepository.save(cartItem2);
                response.setStatusCode(201);
                response.setMessage("Successfully created cart item");





        }catch (Exception e){
             response.setStatusCode(500);
             response.setMessage(e.getMessage());
        }
        return response;
    }
}
