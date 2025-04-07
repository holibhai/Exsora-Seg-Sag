package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Order;
import com.crudoperation.jw.model.OrderItem;
import com.crudoperation.jw.repo.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public Response addOrderItem(OrderItem orderItem) {
        Response response = new Response();
        try{
            Order order = orderItem.getOrder();
            orderItem.setOrder(order);
            repository.save(orderItem);
            response.setMessage("Success");
            response.setStatusCode(201);
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
