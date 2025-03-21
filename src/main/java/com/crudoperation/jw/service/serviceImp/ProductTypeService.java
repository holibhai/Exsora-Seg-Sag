package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.ProductTypeDto;
import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.ProductType;
import com.crudoperation.jw.repo.ProductTypeRepository;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public Response addProductType(ProductType productType) {
        Response response = new Response();
        try{
            ProductType newProductType = productTypeRepository.save(productType);
            response.setProductType(newProductType);
            response.setMessage("Product type added successfully");
            response.setStatusCode(200);

        }catch(Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public Response getProductType() {
        Response response = new Response();
        try{
            List<ProductType> productTypeList = productTypeRepository.findAll();
            List<ProductTypeDto> productTypeDtoList= Utils.mapProductTypeListEntityToProductTypeListDTO(productTypeList);
            response.setProductTypeDtoList(productTypeDtoList);
            response.setStatusCode(200);
            response.setMessage("Product type list successfully");

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
