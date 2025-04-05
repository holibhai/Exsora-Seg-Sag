package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Billing;
import com.crudoperation.jw.model.Delivery;
import com.crudoperation.jw.repo.BillingRepository;
import com.crudoperation.jw.repo.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Response addBill(Billing billing) {
        Response response = new Response();
        try{
            Delivery delivery = billing.getDelivery();
            if(delivery !=null){
                Delivery delivery1=deliveryRepository.save(delivery);
                billing.setDelivery(delivery1);
            }
            billingRepository.save(billing);
            response.setMessage("Successfully addeed billing");
            response.setStatusCode(201);
        }catch (Exception e){
           response.setStatusCode(500);
           response.setMessage(e.getMessage());
        }
        return response;
    }
}
