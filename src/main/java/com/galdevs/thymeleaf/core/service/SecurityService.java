package com.galdevs.thymeleaf.core.service;

public interface SecurityService {

    boolean isAuthenticated();

    void autoLogin(String email, String password);
}
