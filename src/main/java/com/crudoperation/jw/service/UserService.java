package com.crudoperation.jw.service;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.dto.UserAccountDto;
import com.crudoperation.jw.exception.OurException;
import com.crudoperation.jw.model.Address;
import com.crudoperation.jw.model.Role;
import com.crudoperation.jw.repo.AddressRepository;
import com.crudoperation.jw.repo.UserRepository;
import com.crudoperation.jw.model.User;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;





    public Response addUser(User user) {
        Response response=new Response();
        try{
            if(user.getRole()==null){
                user.setRole(Role.valueOf("USER"));
            }
            if(userRepository.existsByUsername(user.getUsername())){
                throw new OurException("User already exists");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Address address = user.getAddress();
            if(address != null) {
                address.setUser(user);
            }
            User savedUser = userRepository.save(user);
            UserAccountDto userAccountDto= Utils.mapUserEntityToUserDTO(savedUser);
            response.setStatusCode(200);
            response.setMessage("User added successfully");
            response.setUserAccountDto(userAccountDto);



        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        return response;


    }
}
