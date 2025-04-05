package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.DeliveryChargeDto;
import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.DeliveryCharge;
import com.crudoperation.jw.repo.DeliveryChargeRepository;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryChargeService {

    @Autowired
    private DeliveryChargeRepository deliveryChargeRepository;

    public Response createDeliveryCharge(DeliveryCharge deliveryCharge) {
        Response response = new Response();
        try{
            deliveryChargeRepository.save(deliveryCharge);
            response.setMessage("Success");
            response.setStatusCode(201);
        }catch(Exception e){
             response.setStatusCode(500);
             response.setMessage(e.getMessage());
        }
        return response;
    }

    public Response getAllDeliveryDetails() {
        Response response = new Response();
        try{
            List<DeliveryCharge> deliveryChargeList = deliveryChargeRepository.findAll();
            List<DeliveryChargeDto>deliveryChargeDtos= Utils.mapDeliveryChargeListEntityToDeliveryChargeListDTO(deliveryChargeList);
            response.setDeliveryChargeDtoList(deliveryChargeDtos);
            response.setStatusCode(200);
            response.setMessage("Success");
        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
