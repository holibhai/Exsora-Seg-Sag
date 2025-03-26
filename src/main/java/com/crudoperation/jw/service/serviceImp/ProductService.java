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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Response addProduct(Product product, MultipartFile imagefile) {
        Response response = new Response();
        System.out.println(product.getProductQuantity());
        System.out.println(product.getProductName());
        System.out.println(product.getProductDescription());
        try{
            System.out.println("dcniece");
            if(imagefile != null && !imagefile.isEmpty()){
                product.setImageName(imagefile.getOriginalFilename());
                product.setImageType(imagefile.getContentType());
                product.setImageData(imagefile.getBytes());
                product.setDate(new Date());
                productRepository.save(product);
                response.setStatusCode(200);
                response.setMessage("Product added successfully");
            }else{
                response.setStatusCode(400);
                response.setMessage("Image file is empty");
            }



        } catch (OurException e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());

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
            List<ProductDto> productDtos=Utils.mapProductListEntityToProductListDTO(products);
            response.setStatusCode(200);
            response.setMessage("Product list successfully");
            response.setProductDtoList(productDtos);
        }catch (OurException e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;

    }

    public Response updateProduct(Product product, MultipartFile imagefile, int productId) {
        Response response = new Response();
        try{
            Optional<Product> productOptional = productRepository.findById(productId);
            if(productOptional.isPresent()){
                if(imagefile!=null || !imagefile.isEmpty()) {
                    productOptional.get().setImageName(imagefile.getOriginalFilename());
                    productOptional.get().setImageType(imagefile.getContentType());
                    productOptional.get().setImageData(imagefile.getBytes());
                }

                  productOptional.get().setProductQuantity(product.getProductQuantity());
                  productOptional.get().setProductName(product.getProductName());
                  productOptional.get().setProductType(product.getProductType());
                  productOptional.get().setProductQuantity(product.getProductQuantity());
                  productOptional.get().setDate(product.getDate());
                  productOptional.get().setDescription(product.getDescription());
                  productOptional.get().setProductQuantity(product.getProductQuantity());
                  productOptional.get().setDepth(product.getDepth());
                  productOptional.get().setHeight(product.getHeight());
                  productOptional.get().setWidth(product.getWidth());
                  productOptional.get().setCategory(product.getCategory());
                  productOptional.get().setWarrantyInf(product.getWarrantyInf());

                productRepository.save(productOptional.get());

//                ProductDto productDto=Utils.mapProductEntityToProductDto(productOptional.get());
                response.setStatusCode(200);
                response.setMessage("Product updated successfully");

//                response.setProductDto(productDto);




            }
        } catch (OurException e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public Response checkQuantity(int id,int quantity) {
          Response response = new Response();
          try{
              int count=productRepository.findProductQuantityById(id);
              if(count>quantity){
                  response.setStatusCode(200);
                  response.setMessage("product available");
              }else{
                  response.setStatusCode(400);
                  response.setMessage("product not available");
                  ProductDto productDto=new ProductDto();
                  productDto.setProductQuantity(count);
                  response.setProductDto(productDto);
              }
          }catch (OurException e) {
              response.setStatusCode(500);
              response.setMessage(e.getMessage());

          }
          return response;
    }
}
