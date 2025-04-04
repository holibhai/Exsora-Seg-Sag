package com.crudoperation.jw.controller;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.Product;
import com.crudoperation.jw.service.serviceImp.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Response> addProduct(@RequestPart Product product ,
                                               @RequestPart MultipartFile imagefile) {
        System.out.println("hello check");
        System.out.println(product.getProductQuantity());
        System.out.println(product.getProductName());
        try {
            Response response = productService.addProduct(product, imagefile);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        Product product = productService.getProduct(productId);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = productService.getProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response>getAllProducts() {
         return ResponseEntity.ok(productService.getAllProduct());
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Response>updateProduct(@RequestPart Product product,@RequestPart(value = "file",required = false) MultipartFile imagefile,@PathVariable int productId) {
        return ResponseEntity.ok(productService.updateProduct(product,imagefile,productId));
    }

    @GetMapping("/checkQuantity/{id}/{quantity}")
    public ResponseEntity<Response>checkQuantity(@PathVariable int id, @PathVariable int quantity) {
        return ResponseEntity.ok(productService.checkQuantity(id,quantity));
    }


}
