package com.crudoperation.jw.dto;

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

    public Response(ProductDto productDto, List<ProductDto> productDtoList) {
        this.productDto = productDto;
        this.productDtoList = productDtoList;
    }

    public Response(UserAccountDto userAccount, int statusCode, String message, String token, List<UserAccountDto> userAccountDtoList, List<AddressDto> addressDtoList, UserAccountDto userAccountDto, AddressDto addressDto, Role role) {
        this.userAccount = userAccount;
        this.statusCode = statusCode;
        this.message = message;
        this.token = token;
        this.userAccountDtoList = userAccountDtoList;
        this.addressDtoList = addressDtoList;
        this.userAccountDto = userAccountDto;
        this.addressDto = addressDto;
        this.role=role;
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

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }
}
