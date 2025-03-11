package com.crudoperation.jw.controller;

import com.crudoperation.jw.service.UserService;
import com.crudoperation.jw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){
        return userService.addUser(user);
    }

}
