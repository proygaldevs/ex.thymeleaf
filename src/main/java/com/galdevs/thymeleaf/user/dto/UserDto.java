package com.galdevs.thymeleaf.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String secondName;
    private String lastNameOne;
    private String lastNameTwo;
    private String gender;
    private String idNumber;
    private String idType;
    private String email;
    private String cellphone;
    private String username;
    private String password;
    private String passwordConfirm;
}
