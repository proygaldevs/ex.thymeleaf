package com.galdevs.thymeleaf.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUsers {

    private String companyName;

    private Integer usersQuantity;
}
