package com.galdevs.thymeleaf.user.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {

    UserDetails loadUserByEmail(String email);
}
