package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Billing;
import com.crudoperation.jw.repo.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Response addBill(Billing billing) {
        Response response = new Response();
        try{
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
