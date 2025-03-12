package com.crudoperation.jw.utils;

import com.crudoperation.jw.dto.UserAccountDto;
import com.crudoperation.jw.model.Role;
import com.crudoperation.jw.model.User;

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
}
