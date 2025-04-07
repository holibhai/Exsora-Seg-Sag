package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.OrderDto;
import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Billing;
import com.crudoperation.jw.model.Order;
import com.crudoperation.jw.model.User;
import com.crudoperation.jw.repo.OrderRepository;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Response addOrder(Order order) {
        Response response = new Response();
        try{
            User user = order.getUser();
            if(user != null){
                order.setUser(user);
            }
            Billing billing = order.getBilling();
            if(billing != null){
                order.setBilling(billing);
            }
            Order order1=orderRepository.save(order);
            OrderDto orderDto= Utils.mapOrderEntityToOrderDto(order1);
            response.setOrderDto(orderDto);
            response.setMessage("Success");
            response.setStatusCode(201);
        }catch(Exception e){
             response.setStatusCode(500);
             response.setMessage(e.getMessage());
        }
        return response;
    }
}
