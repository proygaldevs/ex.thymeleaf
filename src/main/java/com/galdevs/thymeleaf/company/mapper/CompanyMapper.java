package com.galdevs.thymeleaf.company.mapper;

import com.galdevs.thymeleaf.company.dto.CompanyDto;
import com.galdevs.thymeleaf.company.model.Company;
import com.galdevs.thymeleaf.core.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDto, Company> {

    Company toEntity(CompanyDto dto);
}
