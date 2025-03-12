package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Address;
import com.crudoperation.jw.service.serviceImp.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAddresses")
    public ResponseEntity<Response>getAddress() {
         return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/getAddressByUserId/{userId}")
    public ResponseEntity<Response>getAddressById(@PathVariable int userId) {
        return ResponseEntity.ok(addressService.getAddressByUserId(userId));
    }
    @PostMapping("/addAddress/{userId}")
    public ResponseEntity<Response>addAddress(@RequestBody Address address, @PathVariable int userId) {
        return ResponseEntity.ok(addressService.addAddress(address,userId));

    }
}
