package com.galdevs.thymeleaf.company.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galdevs.thymeleaf.company.dto.CompanyDto;
import com.galdevs.thymeleaf.company.mapper.CompanyMapper;
import com.galdevs.thymeleaf.company.model.Company;
import com.galdevs.thymeleaf.company.repository.CompanyRepository;
import com.galdevs.thymeleaf.company.service.CompanyService;
import com.galdevs.thymeleaf.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserService userService;

    @Override
    public void create(CompanyDto companyDto) {
        Company company = companyMapper.toEntity(companyDto);
        companyRepository.save(company);
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyMapper.toDto(companyRepository.findAll());
    }

    @Override
    public String getCompanyUsers() {
        String json = "";
        Map<Object, Object> buildCompanyInfoMap = new HashMap<>();

        companyRepository.findAll().forEach(company ->
                        buildCompanyInfoMap.putAll(
                                buildCompanyUsersMap(company.getName(), userService.countUsersByCompany(company.getId()))));
        try {
            json = new ObjectMapper().writeValueAsString(buildCompanyInfoMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private Map<Object, Object> buildCompanyUsersMap(String companyName, Integer usersQuantity) {
        Map<Object, Object> buildCompanyInfoMap = new HashMap<>();
        buildCompanyInfoMap.put(companyName, usersQuantity);

        return buildCompanyInfoMap;
    }


}
