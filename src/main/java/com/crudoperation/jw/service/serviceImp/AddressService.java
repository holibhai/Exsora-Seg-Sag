package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.AddressDto;
import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.exception.OurException;
import com.crudoperation.jw.model.Address;
import com.crudoperation.jw.model.User;
import com.crudoperation.jw.repo.AddressRepository;
import com.crudoperation.jw.repo.UserRepository;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;
    public Response getAllAddresses() {
        Response response = new Response();
        try {
            List<Address> addresses = addressRepository.findAll();
            List<AddressDto>addressDtos=new ArrayList<>();
            if(addresses!=null) {
                for(Address address : addresses) {
                    AddressDto addressDto = Utils.mapAddressEntityToAddressDto(address);
                    addressDtos.add(addressDto);

                }
            }
            response.setStatusCode(200);
            response.setMessage("Success");
            response.setAddressDtoList(addressDtos);

        } catch (OurException e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public Response getAddressByUserId(int userId) {
        Response response = new Response();
        try{
            Address address=addressRepository.findByUserId(userId).orElseThrow(()->new OurException("userId not found"));
            AddressDto addressDto=Utils.mapAddressEntityToAddressDto(address);
            response.setStatusCode(200);
            response.setMessage("Success");
            response.setAddressDto(addressDto);

        }catch (OurException e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public Response addAddress(Address address,int userId) {
        Response response = new Response();
        try{
            Optional<User> user=userRepository.findById(userId);

            if(user.isPresent()) {

                address.setUser(user.get());
                addressRepository.save(address);
            }else{
                throw new OurException("userId not found");
            }
            response.setStatusCode(200);
            response.setMessage("Success");
            response.setAddressDto(Utils.mapAddressEntityToAddressDto(address));

        }catch (OurException e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
