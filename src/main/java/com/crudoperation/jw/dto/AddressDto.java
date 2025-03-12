package com.crudoperation.jw.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {



    private String street;
    private String city;
    private String state;
    private String zip;

    private UserAccountDto userAccount;
    private List<UserAccountDto> userAccountDtoList;

    public AddressDto(String street, String city, String state, String zip, UserAccountDto userAccount, List<UserAccountDto> userAccountDtoList) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.userAccount = userAccount;
        this.userAccountDtoList = userAccountDtoList;
    }
    public AddressDto() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public UserAccountDto getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountDto userAccount) {
        this.userAccount = userAccount;
    }

    public List<UserAccountDto> getUserAccountDtoList() {
        return userAccountDtoList;
    }

    public void setUserAccountDtoList(List<UserAccountDto> userAccountDtoList) {
        this.userAccountDtoList = userAccountDtoList;
    }
}




