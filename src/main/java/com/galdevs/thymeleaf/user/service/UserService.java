package com.galdevs.thymeleaf.user.service;


import com.galdevs.thymeleaf.user.dto.UserBasicDto;
import com.galdevs.thymeleaf.user.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(UserDto userDto);

    UserDto findByUsername(String username);

    List<UserDto> findAllByUsername(String username);

    List<UserBasicDto> findAll();

    void deleteByUsername(String username);
}
