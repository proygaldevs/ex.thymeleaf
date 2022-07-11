package com.galdevs.thymeleaf.company.controller;

import com.galdevs.thymeleaf.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/users")
    private ResponseEntity<String> getUsersByCompany(){
        return ResponseEntity.ok(companyService.getCompanyUsers());
    }
}
