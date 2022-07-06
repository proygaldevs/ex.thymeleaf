package com.galdevs.thymeleaf.user.service;


import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.model.User;

public interface UserService {

    void save(UserDto userDto);

    User findByUsername(String username);
}
