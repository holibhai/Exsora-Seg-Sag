package com.crudoperation.jw.utils;

import com.crudoperation.jw.dto.AddressDto;
import com.crudoperation.jw.dto.CatagorieDto;
import com.crudoperation.jw.dto.ProductDto;
import com.crudoperation.jw.dto.UserAccountDto;
import com.crudoperation.jw.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static UserAccountDto mapUserEntityToUserDTO(User user){
           UserAccountDto userAccountDto = new UserAccountDto();
           userAccountDto.setId(user.getId());
           userAccountDto.setUsername(user.getUsername());
           userAccountDto.setPassword(user.getPassword());
           userAccountDto.setFirstName(user.getFirstName());
           userAccountDto.setLastName(user.getLastName());
           userAccountDto.setRole(user.getRole());

           return userAccountDto;
    }

    public static AddressDto mapAddressEntityToAddressDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setZip(address.getZip());
        addressDto.setStreet(address.getStreet());

        return addressDto;
    }

    public static ProductDto mapProductEntityToProductDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setProductDescription(product.getProductDescription());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductQuantity(product.getProductQuantity());
        productDto.setProductStatus(product.getProductStatus());
        productDto.setImageData(product.getImageData());
        productDto.setImageType(product.getImageType());
        productDto.setImageName(product.getImageName());
        return productDto;

    }

    public static CatagorieDto mapCatagorieEntityToCatagorieDto(Catagorie catagori){
        CatagorieDto catagorieDto=new CatagorieDto();
        catagorieDto.setId(catagori.getId());
        catagorieDto.setCatagorieDescription(catagori.getCatagorieDescription());
        catagorieDto.setCatagorieType(catagori.getCatagorieType());
        return catagorieDto;

    }

    public static List<ProductDto> mapProductListEntityToProductListDTO(List<Product> productList) {
        return productList.stream().map(Utils::mapProductEntityToProductDto).collect(Collectors.toList());
    }


}
