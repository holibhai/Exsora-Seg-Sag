package com.crudoperation.jw.service.serviceImp;

import com.crudoperation.jw.dto.ProductDto;
import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.exception.OurException;
import com.crudoperation.jw.model.Product;
import com.crudoperation.jw.repo.ProductRepository;
import com.crudoperation.jw.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Response addProduct(Product product, MultipartFile imagefile) {
        Response response = new Response();
        try{
            System.out.println("dcniece");
            product.setImaageName(imagefile.getOriginalFilename());
            product.setImageType(imagefile.getContentType());
            product.setImageData(imagefile.getBytes());
            productRepository.save(product);
            response.setStatusCode(200);
            response.setMessage("Product added successfully");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public Product getProduct(int id) {
         Optional<Product> product = productRepository.findById(id);
         return product.orElse(null);
    }

    public Response getAllProduct() {
        Response response=new Response();
        try{
            List<Product> products=productRepository.findAll();
            List<ProductDto>productDtos=new ArrayList<>();
            for (Product product:products) {
                ProductDto productDto=Utils.mapProductEntityToProductDto(product);
                productDtos.add(productDto);

            }
            response.setStatusCode(200);
            response.setMessage("Product list successfully");
            response.setProductDtoList(productDtos);
        }catch (OurException e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;

    }
}
