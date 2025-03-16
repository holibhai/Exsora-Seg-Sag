package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Catagorie;
import com.crudoperation.jw.service.serviceImp.CatagorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catagorie")
public class CatagorieController {

    @Autowired
    private CatagorieService catagorieService;

    @PostMapping("/add")
    public ResponseEntity<Response> add(@RequestBody Catagorie catagorie){
        return ResponseEntity.ok(catagorieService.add(catagorie));
    }
}
