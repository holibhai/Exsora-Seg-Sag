package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.CatagorieDto;
import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.exception.OurException;
import com.crudoperation.jw.model.Catagorie;
import com.crudoperation.jw.repo.CatagorieRepository;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatagorieService {


    @Autowired
    private CatagorieRepository catagorieRepository;

    public Response add(Catagorie catagorie) {
        Response response = new Response();
        try{
            Catagorie catagorie1=catagorieRepository.save(catagorie);
            response.setMessage("Success");
            response.setStatusCode(200);
            CatagorieDto catagorieDto= Utils.mapCatagorieEntityToCatagorieDto(catagorie1);
            response.setCatagorieDto(catagorieDto);
        }catch(OurException e){
            response.setStatusCode(500);
            response.setMessage("Error");
        }
        return response;
    }
    public Response getCatagorie() {
        Response response = new Response();
//        List<Catagorie> catagorieList=new ArrayList<Catagorie>();
        try{
            List<Catagorie> catagories=catagorieRepository.findAll();
            List<CatagorieDto> catagorieDtoList=Utils.mapCatagorieListEntityToCatagorieListDTO(catagories);
            response.setCatagorieDtoList(catagorieDtoList);
            response.setMessage("Success");
            response.setStatusCode(200);

        }catch(OurException e){
            response.setStatusCode(500);
            response.setMessage("Error");

        }
        return response;
    }
}
