package com.crudoperation.jw.controller;

import com.crudoperation.jw.service.FavauriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favaurite")
public class FavauriteController {

    @Autowired
    private FavauriteService favauriteService;
}
