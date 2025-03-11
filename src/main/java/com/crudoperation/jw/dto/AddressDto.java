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
}




