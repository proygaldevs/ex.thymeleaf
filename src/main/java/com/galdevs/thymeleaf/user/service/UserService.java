package com.galdevs.thymeleaf.user.service;


import com.galdevs.thymeleaf.user.model.User;

public interface UserService {

    void save(User user);

    User findByEmail(String email);
}
