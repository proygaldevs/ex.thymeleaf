package com.galdevs.thymeleaf.company.service;

import com.galdevs.thymeleaf.company.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    void create(CompanyDto companyDto);

    List<CompanyDto> findAll();

    String getCompanyUsers();
}
