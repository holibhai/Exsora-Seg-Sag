package com.crudoperation.jw.service;

import com.crudoperation.jw.model.Address;
import com.crudoperation.jw.repo.AddressRepository;
import com.crudoperation.jw.repo.UserRepository;
import com.crudoperation.jw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;





    public User addUser(User user) {
        Address address = user.getAddress();
        if(address != null) {
            address.setUser(user);
        }
        return userRepository.save(user);
    }
}
