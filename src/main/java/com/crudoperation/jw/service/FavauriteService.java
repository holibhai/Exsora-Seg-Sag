package com.crudoperation.jw.service;

import com.crudoperation.jw.repo.FavauriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavauriteService {

    @Autowired
    private FavauriteRepository favauriteRepository;
}
