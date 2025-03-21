package com.crudoperation.jw.dto;

import com.crudoperation.jw.model.ProductType;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.management.relation.Role;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

  private UserAccountDto userAccount;
  private int statusCode;
  private String message;
  private String token;
  private Role role;

  private List<UserAccountDto> userAccountDtoList;
  private List<AddressDto>addressDtoList;
  private UserAccountDto userAccountDto;
  private AddressDto addressDto;
  private ProductDto productDto;
  private List<ProductDto> productDtoList;
  private CatagorieDto catagorieDto;
  private List<CatagorieDto> catagorieDtoList;
  private ProductType productType;
  private List<ProductTypeDto> productTypeDtoList;


    public Response(UserAccountDto userAccount, int statusCode, String message, String token, Role role, List<UserAccountDto> userAccountDtoList, List<AddressDto> addressDtoList, UserAccountDto userAccountDto, AddressDto addressDto, ProductDto productDto, List<ProductDto> productDtoList, CatagorieDto catagorieDto, List<CatagorieDto> catagorieDtoList, ProductType productType, List<ProductTypeDto> productTypeDtoList) {
        this.userAccount = userAccount;
        this.statusCode = statusCode;
        this.message = message;
        this.token = token;
        this.role = role;
        this.userAccountDtoList = userAccountDtoList;
        this.addressDtoList = addressDtoList;
        this.userAccountDto = userAccountDto;
        this.addressDto = addressDto;
        this.productDto = productDto;
        this.productDtoList = productDtoList;
        this.catagorieDto = catagorieDto;
        this.catagorieDtoList = catagorieDtoList;
        this.productType = productType;
        this.productTypeDtoList = productTypeDtoList;
    }

    public Response(){}


    public UserAccountDto getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountDto userAccount) {
        this.userAccount = userAccount;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<UserAccountDto> getUserAccountDtoList() {
        return userAccountDtoList;
    }

    public void setUserAccountDtoList(List<UserAccountDto> userAccountDtoList) {
        this.userAccountDtoList = userAccountDtoList;
    }

    public List<AddressDto> getAddressDtoList() {
        return addressDtoList;
    }

    public void setAddressDtoList(List<AddressDto> addressDtoList) {
        this.addressDtoList = addressDtoList;
    }

    public UserAccountDto getUserAccountDto() {
        return userAccountDto;
    }

    public void setUserAccountDto(UserAccountDto userAccountDto) {
        this.userAccountDto = userAccountDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList() {
        this.productDtoList = productDtoList;
    }

    public CatagorieDto getCatagorieDto() {
        return catagorieDto;
    }

    public void setCatagorieDto(CatagorieDto catagorieDto) {
        this.catagorieDto = catagorieDto;
    }

    public List<CatagorieDto> getCatagorieDtoList() {
        return catagorieDtoList;
    }

    public void setCatagorieDtoList(List<CatagorieDto> catagorieDtoList) {
        this.catagorieDtoList = catagorieDtoList;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    public List<ProductTypeDto> getProductTypeDtoList() {
        return productTypeDtoList;
    }

    public void setProductTypeDtoList(List<ProductTypeDto> productTypeDtoList) {
        this.productTypeDtoList = productTypeDtoList;
    }
}
