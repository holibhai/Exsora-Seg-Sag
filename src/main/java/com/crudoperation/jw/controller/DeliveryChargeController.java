package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.DeliveryCharge;
import com.crudoperation.jw.service.serviceImp.DeliveryChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveryCharge")
public class DeliveryChargeController {

    @Autowired
    private DeliveryChargeService deliveryChargeService;

    public ResponseEntity<Response> createDeliveryCharge(@RequestBody DeliveryCharge deliveryCharge) {
         return ResponseEntity.ok(deliveryChargeService.createDeliveryCharge(deliveryCharge));
    }
}
