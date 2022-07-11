package com.galdevs.thymeleaf.company.repository;

import com.galdevs.thymeleaf.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {}